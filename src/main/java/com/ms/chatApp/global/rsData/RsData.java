package com.ms.chatApp.global.rsData;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RsData<T> {
    private String resultCode; // 상태 코드
    private String resultMessage; // 메세지
    private T data; // 제네릭 타입 T의 데이터

    public static <T> RsData<T> of(String resultCode, String resultMessage, T data) {
        return new RsData<>(resultCode, resultMessage, data);
    }

    public static <T> RsData<T> of(String resultCode, String resultMessage) {
        return of(resultCode, resultMessage, null);
    }

    public boolean isSuccess() {
        return resultCode.startsWith("S-");
    }

    public boolean isFail() {
        return !isSuccess();
    }
}
