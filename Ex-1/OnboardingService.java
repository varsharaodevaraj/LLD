import java.util.*;

public class OnboardingService {
    private final Store st;
    private final StudentParser parser = new StudentParser();
    private final StudentValidator validator = new StudentValidator();
    private final Printer printer = new Printer();

    public OnboardingService(FakeDb db) { st = db; }

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {
        printer.printInput(raw);

        Map<String,String> kv = parser.parseToMap(raw);

        String name = kv.getOrDefault("name", "");
        String email = kv.getOrDefault("email", "");
        String phone = kv.getOrDefault("phone", "");
        String program = kv.getOrDefault("program", "");

        // validation inline, printing inline
        List<String> errors = validator.validator(name, email, phone, program);

        if (!errors.isEmpty()) {
            printer.printErrors(errors);
            return;
        }

        String id = IdUtil.nextStudentId(st.count());
        StudentRecord rec = new StudentRecord(id, name, email, phone, program);

        st.save(rec);

        printer.printSucess(id, st.count(), rec);
    }
}