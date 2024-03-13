package persistence.sql.dml;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import persistence.entity.EntityId;
import persistence.sql.model.Table;
import persistence.study.sql.ddl.Person1;
import persistence.study.sql.ddl.Person2;
import persistence.study.sql.ddl.Person3;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class ByIdQueryBuilderTest {
    @DisplayName("Person을 이용하여 byId 쿼리 생성하기")
    @ParameterizedTest
    @MethodSource
    void build(Table table, EntityId id, String byIdQuery) {
        ByIdQueryBuilder byIdQueryBuilder = new ByIdQueryBuilder(table, id);

        String result = byIdQueryBuilder.build();

        assertThat(result).isEqualTo(byIdQuery);
    }

    private static Stream<Arguments> build() {
        return Stream.of(
                Arguments.arguments(new Table(Person1.class), new EntityId(1L), "person1.id=1"),
                Arguments.arguments(new Table(Person2.class), new EntityId(2L), "person2.id=2"),
                Arguments.arguments(new Table(Person3.class), new EntityId(500L), "users.id=500")
        );
    }
}
