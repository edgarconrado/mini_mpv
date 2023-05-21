package net.tecgurus.mpv.auth.model;

import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthErrorResponse {

    @Builder.Default
    private String type = "about:black";
    private String title;
    private Integer status;
    private String details;
}
