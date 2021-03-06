package com.ertho.gestiondestosck.validator;

import com.ertho.gestiondestosck.dto.MvtStkDto;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class MvtStkValidator {

    public static List<String> validate(MvtStkDto dto) {
        List<String> errors = new ArrayList<>();

        if (dto == null) {
            errors.add("Veuillez renseigner la quantite de l'article");
            errors.add("Veuillez renseigner la date de stock");
            errors.add("Veuillez renseigner l'article'");
            errors.add("Veuillez renseigner le type de mouvement de stock");
            return errors;
        }

        if (dto.getQuantite() == null || dto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
            errors.add("Veuillez renseigner la quantite de l'article");
        }
        if (dto.getDateMvt() == null) {
            errors.add("Veuillez renseigner la date de stock");
        }

        if (dto.getArticle() == null || dto.getArticle().getId() == null) {
            errors.add("Veuillez renseigner l'article'");
        }

        if (!StringUtils.hasLength(dto.getTypeMvt().name())) {
            errors.add("Veuillez renseigner le type de mouvement de stock");
        }
        return errors;
    }
}
