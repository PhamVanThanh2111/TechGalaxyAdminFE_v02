package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.SystemUserRequestDTO;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.SystemUserResponseDTO;

public interface SystemUserService {
    DataResponse<SystemUserResponseDTO> findAll(String accessToken);

    DataResponse<SystemUserResponseDTO> findById(String id, String accessToken);

    DataResponse<SystemUserResponseDTO> findByEmail(String email, String accessToken);

    DataResponse<SystemUserResponseDTO> create(SystemUserRequestDTO systemUserRequestDTO, String accessToken);

    DataResponse<SystemUserResponseDTO> update(SystemUserRequestDTO systemUserRequestDTO, String accessToken);

    DataResponse<Void> delete(String id, String accessToken);
}
