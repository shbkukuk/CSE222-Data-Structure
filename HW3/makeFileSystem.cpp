#include "structFileSystem.h"
#include <iostream>
#include <fcntl.h>
#include <unistd.h>
#include <cstring>
#include <cerrno>

using namespace std;

int* fat = nullptr;
int capacity = 0;
uint8_t* freeBlocksBitmap = nullptr;
entryDir* directories = nullptr;

class fileSystem
{
    public:
        void createFile();
        int openFile();
        void initSystem();
        void printInfo();
        fileSystem(int blockSize, char *fileName);

    private:
        int  blockSize;
        char *fileName;
        superBlock disk;
};

int main(int argc, char* argv[])
{
    if(argc != 3)
    {
        cout<<"Missing Field"<<endl;
        return 0;
    }

    int blockSize = stof(argv[1]);
    fileSystem file(blockSize,argv[2]);
    file.createFile();
    
    return 0;

}

fileSystem::fileSystem(int blockSize, char *fileName)
{
    this->blockSize = blockSize;
    this->fileName = fileName;
    superBlock disk;
    this->disk=disk;
}

void fileSystem::createFile()
{
    int fileSize = static_cast<int>(blockSize * 2048);
    int fd = openFile();
    ftruncate(fd, fileSize * 1024);
    initSystem();
}

int fileSystem::openFile()
{
    int fd = open(fileName, O_RDWR | O_CREAT | O_EXCL, 0666);
    if (fd < 0) {
        if (errno == EEXIST) {
            remove(fileName);
            return openFile();
        }
        exit(EXIT_FAILURE);
    }
    return fd;
}

void fileSystem::initSystem(){
    int fileSize = static_cast<int>(this->blockSize * 4096);
    int mb = static_cast<int>(this->blockSize * 8);
    
    this->disk.blockSize = blockSize;
    this->disk.diskSize = mb;
    this->disk.numberOfEntry = (fileSize * 1024) / 32;
    this->disk.numberOfBlock = fileSize / blockSize;
    this->disk.totalByte = fileSize * 1024;
    this->disk.bootSectorPosition = 0;
    this->disk.fatTablePosition = this->disk.totalByte - (this->disk.totalByte - sizeof(superBlock)) + 1;
    this->disk.rootDirPosition = this->disk.totalByte - (this->disk.totalByte - sizeof(superBlock) - (18 * this->disk.blockSize * 1024));
    this->disk.dataStartPosition = this->disk.rootDirPosition + sizeof(entryDir) + 1;
    strcpy(this->disk.diskName, fileName);
    printInfo();
}


void fileSystem::printInfo()
{
    cout << "\n\t****Virtual Disk Has Created!****\n";
    cout << "-----------------------------------------------------\n";
    cout << "Disk Name: " << disk.diskName << endl;
    cout << "Disk Size: " << disk.diskSize << "MB\n";
    cout << "Block Size: " << disk.blockSize << "KB\n";
    cout << "Number of Block: " << disk.numberOfBlock << endl;
    cout << "Boot Sector Start Address: " << disk.bootSectorPosition << endl;
    cout << "FAT Table Start Address: " << disk.fatTablePosition << endl;
    cout << "Root Directory Start Address: " << disk.rootDirPosition << endl;
    cout << "Data Region Start Address: " << disk.dataStartPosition << endl;
    cout << "-----------------------------------------------------\n\n";
}