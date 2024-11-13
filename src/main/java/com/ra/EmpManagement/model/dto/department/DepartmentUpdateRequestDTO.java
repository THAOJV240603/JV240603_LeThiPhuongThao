package com.ra.EmpManagement.model.dto.department;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DepartmentUpdateRequestDTO {
    private Long Dept_id;
    @NotBlank(message = "Không rỗng")
    private String Dept_name;
    @NotBlank(message = "Không rỗng")
    private String Dept_description;
    private Boolean Dept_status;
}
