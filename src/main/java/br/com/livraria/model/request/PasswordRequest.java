package br.com.livraria.model.request;

import br.com.livraria.validation.MatchPassword;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PasswordRequest {

    @MatchPassword
    private String oldPassword;
    private String newPassword;

}
