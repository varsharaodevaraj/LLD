public class IdUtil {
    public static String nextStudentId(int currentCount) {
        int next = currentCount + 1;
        String num = String.format("%04d", next);
        return "SST-2026-" + num;
    }
}
// varsharao@Varshas-MacBook-Air Ex-1 % java Main
// === Student Onboarding ===
// INPUT: name=Riya;email=riya@sst.edu;phone=9876543210;program=CSE
// OK: created student SST-2026-0001
// Saved. Total students: 1
// CONFIRMATION:
// StudentRecord{id='SST-2026-0001', name='Riya', email='riya@sst.edu', phone='9876543210', program='CSE'}

// -- DB DUMP --
// | ID             | NAME | PROGRAM |
// | SST-2026-0001  | Riya | CSE     |