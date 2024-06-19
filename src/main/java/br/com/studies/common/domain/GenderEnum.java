package br.com.studies.common.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor
public enum GenderEnum {
    MALE("MALE"),
    FEMALE("FEMALE");

    private final String desc;

    public static GenderEnum getStatus(String status) {
        return Arrays.stream(GenderEnum.values())
                .filter(genderStatusEnum -> genderStatusEnum.getDesc().equals(status))
                .findFirst()
                .orElseThrow(() -> new RuntimeException(String.format("Try to error find gender %s", status)));

    }
}
