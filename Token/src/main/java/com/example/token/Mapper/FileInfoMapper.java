package com.example.token.Mapper;

import com.example.token.Entity.BO.netdisk.FileInfoBO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface FileInfoMapper{
    List<FileInfoBO> getFileList(FileInfoBO fileInfoBO);
    Boolean insertFileInfo(FileInfoBO fileInfoBO);
}
