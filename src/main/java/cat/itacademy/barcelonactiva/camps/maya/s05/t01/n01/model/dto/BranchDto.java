package cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.dto;

import cat.itacademy.barcelonactiva.camps.maya.s05.t01.n01.model.enums.Type;
import jakarta.persistence.*;
import lombok.*;
import org.apache.commons.text.WordUtils;


import java.util.*;

@Getter
@Setter
@NoArgsConstructor
public class BranchDto {

    private final List<String> EUROPEAN_COUNTRIES = Arrays.asList("Austria", "Belgium", "Bulgaria", "Croatia", "Republic of Cyprus", "Czech Republic", "Denmark", "Estonia", "Finland", "France", "Germany", "Greece", "Hungary", "Ireland", "Italy", "Latvia", "Lithuania", "Luxembourg", "Malta", "Netherlands", "Poland", "Portugal", "Romania", "Slovakia", "Slovenia", "Spain", "Sweden");
    private Integer id;
    private String name;
    private String country;
    @Enumerated(EnumType.STRING)
    private Type type;

    public BranchDto(Integer id, String name, String country){
        this.id=id;
        this.name = WordUtils.capitalize(name);
        this.country = WordUtils.capitalize(country);
        this.type = getType(country);
    }

    private Type getType(String country){
        if (isEuropean(country)){
            return Type.EU;
        }
        return Type.NON_EU;
    }

    private boolean isEuropean(String country){
        return EUROPEAN_COUNTRIES.stream().anyMatch(country::equalsIgnoreCase);
    }

    @Override
    public String toString(){
        return "\n{\n\tBranch name: " + name +
                "\n\tCountry: " + country +
                "\n\tEU/non-EU: " + type + "\n}\n";
    }
}
