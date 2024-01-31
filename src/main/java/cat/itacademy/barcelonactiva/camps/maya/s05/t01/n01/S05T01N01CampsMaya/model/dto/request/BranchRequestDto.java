package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.S05T01N01CampsMaya.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BranchRequestDto {
    @Size(min=4, max=30, message = "Must be between 4 and 30 characters")
    @NotBlank(message = "Please work")
    @Pattern(regexp = "^[a-zA-Z0-9 ]*$",message = "Cannot include special characters")
    private String name;

    @NotBlank(message = "Must choose a country")
    private String country;
}