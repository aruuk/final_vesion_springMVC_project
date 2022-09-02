package peaksoft.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "videos")
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "lesson")
public class Video {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "video_seq", sequenceName = "video_seq", allocationSize = 1)
    private Long id;
    @Column(name = "video_name")
    private String videoName;
    @Column(length = 20000)
    private String link;

    @OneToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.DETACH})
    private Lesson lesson;
}
