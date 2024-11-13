package com.ra.EmpManagement.model.dto.department;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentRequestDTO {
    @NotBlank(message = "Không rỗng")
    private String Dept_name;
    @NotBlank(message = "Không rỗng")
    private String Dept_description;
    private Boolean Dept_status;
}
