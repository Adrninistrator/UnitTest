package adrninistrator.test_jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity(name = "adrninistrator.test_jpa.entity.TestTable3")
@Table(name = "test_table3",
        indexes = {
                @Index(name = "idx_test_table3_1", columnList = "create_time")
        })
@IdClass(TestTable3.PrimaryKeys.class)
public class TestTable3 {
    @Data
    public static class PrimaryKeys implements Serializable {
        private String id;
        private String flag;
    }

    /**
     * id
     */
    @Id
    @Column(name = "\"id\"", length = 32, nullable = false)
    private String id;
    /**
     * flag
     */
    @Id
    @Column(name = "\"flag\"", length = 32, nullable = false)
    private String flag;
    /**
     * create_time
     */
    @Column(name = "\"create_time\"", length = 19, nullable = false)
    private Timestamp createTime;
    /**
     * update_time
     */
    @Column(name = "\"update_time\"", length = 19, nullable = false)
    private Timestamp updateTime;
}