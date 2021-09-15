package hu.flowacademy.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
public class MovieModel {
    private final String id;
    private final String title;
    private final String description;
    private final String directorName;
    private final LocalDateTime releasedAt;
}
