package iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.request.CustomerRequest;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.CustomerResponse;
import iuh.fit.se.techgalaxy.frontend.admin.techgalaxyadminfe.dto.response.DataResponse;

public interface CustomerService {
    DataResponse<CustomerResponse> findByEmail(String email, String accessToken);

    DataResponse<CustomerResponse> findAll(String accessToken);

    DataResponse<CustomerResponse> findById(String id, String accessToken);

    DataResponse<CustomerResponse> save(CustomerRequest customerRequest, String accessToken) throws JsonProcessingException;

    DataResponse<CustomerResponse> update(CustomerRequest customerRequest, String accessToken) throws JsonProcessingException;

    DataResponse<Boolean> delete(String id, String accessToken);
}
