#ifndef  STRUCT_H
#define STRUCT_H


#include <stdint.h>

/**
 * uint8_t    1 byte
    uint16_t  2 bytes
    uint32_t  4 bytes
*/
struct superBlock
{
    char diskName[20];
    uint32_t diskSize;
    float blockSize;
    uint32_t numberOfEntry;
    uint32_t numberOfBlock;
    uint32_t totalByte;
    uint32_t bootSectorPosition;
    uint32_t fatTablePosition;
    uint32_t rootDirPosition;
    uint32_t dataStartPosition;

};

struct  entryDir
{
    char fileName[8]; //8 byte
    char extension[3]; // 3 byte
    uint8_t attributes; // 1 byte
    char reserved[10]; //10 byte
    uint16_t time; // 2 byte
    uint16_t date; // 2 byte
    uint16_t firstBlockNumber; // 2 byte
    uint32_t fileSize; // 4 byte
};









#endif