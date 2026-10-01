package com.projects.buildora.Service;

import com.projects.buildora.dto.project.FileNode;

import java.util.List;

public interface FIleService {
    List<FileNode> getFileTree(Long projectId, Long userId);

    FileContentResponse getFileContent(Long projectId, String path, Long userId);
}
