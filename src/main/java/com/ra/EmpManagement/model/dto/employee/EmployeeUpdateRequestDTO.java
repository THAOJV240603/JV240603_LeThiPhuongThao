package com.ra.EmpManagement.model.dto.employee;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class EmployeeUpdateRequestDTO {
    private Long Emp_id;
    @NotBlank(message = "Không rỗng")
    private String Emp_name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    @Past(message = "Ngày sinh phải là ngày trong quá khứ")
    private LocalDate Emp_BirthOfDate;
    private Boolean Emp_sex;
    @NotBlank(message = "Không rỗng")
    private String Emp_address;
    @NotBlank(message = "Không rỗng")
    @Pattern(regexp = "[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}",
            message = "Email không đúng định dạng")
    private String Emp_email;
    @NotBlank(message = "Không rỗng")
    @Pattern(regexp = "^(0[3|5|7|8|9])+([0-9]{8})$",
            message = "Số điện thoại không đúng định dạng")
    private String Emp_phone;
    @NotBlank(message = "Không rỗng")
    private String Emp_avatar;
    private Boolean Emp_status;
    private Long Dept_id;
}
