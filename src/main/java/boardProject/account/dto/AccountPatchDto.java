package boardProject.account.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountPatchDto {

    private String name;

    private String phoneNum;

    private String nickname;

    private String email;

    private String password;



}
