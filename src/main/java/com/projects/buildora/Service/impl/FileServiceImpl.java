package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.FIleService;
import com.projects.buildora.dto.project.FileContentResponse;
import com.projects.buildora.dto.project.FileNode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FileServiceImpl implements FIleService {
    @Override
    public List<FileNode> getFileTree(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public FileContentResponse getFileContent(Long projectId, String path, Long userId) {
        return null;
    }

}
