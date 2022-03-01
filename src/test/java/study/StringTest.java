package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    /**
     * 요구사항 1
     * "1,2"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인하는 학습 테스트를 구현한다.
     * "1"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지에 대한 학습 테스트를 구현한다.
     *
     * 힌트
     * 배열로 반환하는 값의 경우 assertj의 contains()를 활용해 반환 값이 맞는지 검증한다.
     * 배열로 반환하는 값의 경우 assertj의 containsExactly()를 활용해 반환 값이 맞는지 검증한다.
     */

    @Test
    void 요구사항1_1(){
        String[] split = "1,2".split(",");
        assertThat(split).contains("1", "2");
    }

    @Test
    void 요구사항1_2(){
        String[] split = "1".split(",");
        assertThat(split).containsExactly("1");
    }

    /**
     * 요구사항 2
     * "(1,2)" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 "1,2"를 반환하도록 구현한다.
     */

    @Test
    void 요구사항2(){
        String substring = "(1,2)".substring(1, 4);
        assertThat(substring).isEqualTo("1,2");
    }

    /**
     * 요구사항 3
     * "abc" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습 테스트를 구현한다.
     * String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습 테스트를 구현한다.
     * JUnit의 @DisplayName을 활용해 테스트 메소드의 의도를 드러낸다.
     *
     * 힌트
     * AssertJ Exception Assertions 문서 참고
     * 자주 발생하는 Exception의 경우 Exception별 메서드 제공하고 있음
     * assertThatIllegalArgumentException()
     * assertThatIllegalStateException()
     * assertThatIOException()
     * assertThatNullPointerException()
     */

    @Test
    void 요구사항3(){

        assertThatThrownBy(() -> {
            "abc".charAt(3);
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }


    //  아래의 종류의 method 또한 assertThatExceptionOfType()을 사용
    //    * assertThatIllegalArgumentException()
    //     * assertThatIllegalStateException()
    //     * assertThatIOException()
    //     * assertThatNullPointerException()
    @Test
    void 요구사항3_1(){
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class).isThrownBy(() -> {
            "abc".charAt(3);
        }).withMessage("String index out of range: 3")
                .withMessage("String index out of range: %s", 3)
                .withMessageContaining("String index out of range") //
                .withNoCause(); // 실제 Throwable 이 예상하는 Exception 과 다른지 확인
    }


}
