package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.SystemUserRequestDTO;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.UserRegisterRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.SystemUserResponseDTO;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.UserRegisterResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.entities.enumeration.Gender;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services.SystemUserService;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class SystemUserServiceImpl implements SystemUserService {
    private final RestClient restClient;
    private final ObjectMapper objectMapper;
    private static final String ENDPOINT = "http://localhost:8081";

    private boolean isAvatarMissing(SystemUserRequestDTO systemUserRequestDTO) {
        return systemUserRequestDTO.getAvatar() == null || systemUserRequestDTO.getAvatar().isEmpty();
    }

    public SystemUserServiceImpl(ObjectMapper objectMapper, RestClient restClient) {
        this.objectMapper = objectMapper;
        this.restClient = restClient;
    }

    @Override
    public DataResponse<SystemUserResponseDTO> findAll(String accessToken) {
        return restClient.get()
                .uri(ENDPOINT + "/system-users/all")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    @Override
    public DataResponse<SystemUserResponseDTO> findById(String id, String accessToken) {
        return restClient.get()
                .uri(ENDPOINT + "/system-users/" + id)
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    @Override
    public DataResponse<SystemUserResponseDTO> findByEmail(String email, String accessToken) {
        return restClient.get()
                .uri(ENDPOINT + "/system-users/email/" + email)
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }

    @Override
    public DataResponse<SystemUserResponseDTO> create(SystemUserRequestDTO systemUserRequestDTO, String accessToken) {
        UserRegisterRequest userRegisterRequest = new UserRegisterRequest();
        userRegisterRequest.setEmail(systemUserRequestDTO.getAccount().getEmail());
        userRegisterRequest.setPassword("123456");
        userRegisterRequest.setFullName(systemUserRequestDTO.getName());

        DataResponse<UserRegisterResponse> accountResponse = restClient.post()
                .uri(ENDPOINT + "/api/accounts/auth/create-system-user-account")
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .body(userRegisterRequest)
                .exchange((request, response) -> {
                    DataResponse<UserRegisterResponse> dataAccountResponse = null;
                    if (response.getBody().available() > 0) {
                        dataAccountResponse = objectMapper.readValue(response.getBody(), new TypeReference<>() {});
                    }
                    assert dataAccountResponse != null;
                    return dataAccountResponse;
                });

        if (accountResponse.getData() == null) {
            throw new RuntimeException("Failed to register account.");
        }

        List<UserRegisterResponse> list = (List<UserRegisterResponse>) accountResponse.getData();
        UserRegisterResponse userRegisterResponse = list.get(0);

        SystemUserResponseDTO.AccountResponse account = new SystemUserResponseDTO.AccountResponse();
        account.setId(userRegisterResponse.getId());

        return restClient.post()
                .uri(ENDPOINT + "/system-users")
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .body(systemUserRequestDTO)
                .exchange((request, response) -> {
                    DataResponse<SystemUserResponseDTO> dataResponse = null;
                    if (response.getBody().available() > 0) {
                        dataResponse = objectMapper.readValue(response.getBody(), new TypeReference<>() {
                        });
                    }
                    assert dataResponse != null;
                    return dataResponse;
                });
    }

    @Override
    public DataResponse<SystemUserResponseDTO> update(SystemUserRequestDTO systemUserRequestDTO, String accessToken) {

        return restClient.put()
                .uri(ENDPOINT + "/system-users/" + systemUserRequestDTO.getId())
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .body(systemUserRequestDTO)
                .exchange((request, response) -> {
                    DataResponse<SystemUserResponseDTO> dataResponse = null;
                    if (response.getBody().available() > 0) {
                        dataResponse = objectMapper.readValue(response.getBody(), new TypeReference<>() {});
                    }
                    assert dataResponse != null;
                    return dataResponse;
                });
    }

    @Override
    public DataResponse<Void> delete(String id, String accessToken) {
        return restClient.delete()
                .uri(ENDPOINT + "/system-users/" + id)
                .header("Authorization", "Bearer " + accessToken)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {});
    }
}
