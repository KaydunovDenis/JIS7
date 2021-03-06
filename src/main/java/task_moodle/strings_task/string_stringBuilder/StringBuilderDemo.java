package task_moodle.strings_task.string_stringBuilder;

import org.junit.Test;

/**
 * Из слов приведенного текста составить фразу:
 * "Выбирать решения - это легко." Освойте все методы StringBuilder:
 * - append;
 * - insert;
 * - delete;
 * - replace.
 * Приведите тип полученного объекта к классу String.
 */
public class StringBuilderDemo {

    @Test
    public void test() {
        StringBuilder text = new StringBuilder();
        text.append("Те, кто добивается выдающихся результатов, обращают внимание даже на самые незначительные детали.")
                .append(" Они чаще принимают мелкие, почти незаметные, но верные бытовые решения. Каждый день. ")
                .append("Дело не в таланте, просто однажды они решили поступать именно так. Выбирать нужное. ")
                .append("Если бы люди поняли, что страхи не имеют никакой связи с реальностью, всем жилось бы куда лучше. ")
                .append("Момент принятия решения поистине волшебен. Вы решаетесь что-то сделать, ")
                .append("коренным образом изменить свою жизнь — и она предстает перед вами в новом свете. ")
                .append("Эмоции не дают нам выйти из зоны комфорта, но, если вы хотите стать лучше, ")
                .append("придется постоянно переступать через себя и покидать ее. Вы и представить не можете, ")
                .append("насколько расширится ваш диапазон позитивных эмоций, если вы только найдете силы шагнуть ")
                .append("в неизвестность и взять на себя больше ответственности. Любому человеку очень важно найти что-то,")
                .append(" к чему он будет стремиться и за что будет бороться вне зависимости от обстоятельств. ")
                .append("После того как вы поставите перед собой правильную цель, принимать решения будет легко и весело. ")
                .append("То, что раньше казалось мучительной обязанностью, превратится в приятное занятие. ")
                .append("То, что получилось у других, получится и у вас. Единственная вещь в этом мире, ")
                .append("которую вы действительно можете контролировать, — это ваши мысли. Сначала человек думает, ")
                .append("потом говорит, потом делает как говорит, действия формируют харрактер, а он влияет на всю жизнь. ")
                .append("Если вы умеете управлять своими мыслями, вы умеете управлять своей жизнью.");
        System.out.println(text);
        System.out.println();
        text.delete(0, 249)
                .delete(9, 766)
                .delete(29, 461);
        System.out.println(text);
        text.replace(18, 23, "это");
        System.out.println(text);
        text.insert(18, "- ");
        String result = text.toString();
        System.out.println(result);
    }
}
