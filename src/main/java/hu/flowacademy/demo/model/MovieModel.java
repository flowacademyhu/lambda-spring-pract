package hu.flowacademy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class MovieModel {
    private final String id;
    @NotBlank
    private final String title;
    private final String description;
    @NotBlank
    private final String directorName;
    @NotNull
    private final LocalDateTime releasedAt;
}
