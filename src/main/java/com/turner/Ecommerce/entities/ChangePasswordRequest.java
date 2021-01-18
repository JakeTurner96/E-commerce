package com.turner.Ecommerce.entities;
import com.sun.istack.NotNull;
import lombok.Data;

@Data
public class ChangePasswordRequest {
    @NotNull
    private String oldPassword;
    @NotNull
    private String newPassword;
    @NotNull
    private String confirmNewPassword;
}
