package ua.azbest.dao;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "session")
public class Session {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "time_start")
    private Date timeStart;

    @Column(name = "time_stop")
    private Date timeStop;

    @Column(name = "score")
    private int score;

}
