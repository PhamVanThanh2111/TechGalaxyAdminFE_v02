package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.MemoryRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.Memory;

public interface MemoryService {
    public DataResponse<Memory> getAllMemories();
    public DataResponse<Memory> getMemoryById(String id);
    public DataResponse<Memory> updateMemory(String id,MemoryRequest memoryRequest ,String accessToken);
    public DataResponse<Memory> createMemory(MemoryRequest memoryRequest,String accessToken);
    public DataResponse<Memory> deleteMemory(String memoryId,String accessToken);
}
