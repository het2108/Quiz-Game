import java.util.Scanner;
public class QUIZ {
    public static void main(String[] args) {
        Stud_info si=new Stud_info();
    }
}
class Stud_info {
  static   Scanner sc = new Scanner(System.in);
    static String id;
    static String name;
    static String num;
    static DoubleLinkList DLL = new DoubleLinkList();
    static DoubleEndedQueue CorrectAns ;
    static DoubleEndedQueue Playersans ;
    Stud_info(){
        InitialiseQuestion();
        System.out.println("  YOU ARE ADMIN OR PLAYER ??   \n1->ADMIN\n2->PLAYER");
        int choice=sc.nextInt();
        if(choice==2){
            System.out.println("                                                                                 ");
            System.out.println("                                                --------------------------------");
            System.out.println("                                                *     WELCOME TO QUIZ GAME       *");
            System.out.println("                                                --------------------------------");
            System.out.println("                                                                                 ");
            Stud_info_details();
        }
        else{
            System.out.println("WELCOME BACK !");
            while(true){
                System.out.println("     \n   WHAT WOULD YOU LIKE TO DO ??\n1->Add Question\n2->View Questions\n3>View answers\n4->Update answer\n5->EXIT");
            int choice2=sc.nextInt();
            switch (choice2) {
                case 1:
                    System.out.println("Enter num of question you want to add ");
                    int num=sc.nextInt();
                    for(int i=0;i<num;i++){
                        CorrectAns=new DoubleEndedQueue(10+num);
                        Playersans=new DoubleEndedQueue(10+num);
                        System.out.print("Enter the Question : ");
                        sc.nextLine();
                        String question = sc.nextLine();
                        System.out.print("Enter Option A : ");
                        String optionA = sc.nextLine();
                        System.out.print("Enter Option B : ");
                        String optionB = sc.nextLine();
                        System.out.print("Enter Option C : ");
                        String optionC = sc.nextLine();
                        System.out.print("Enter Option D : ");
                        String optionD = sc.nextLine();
                        System.out.print("Correct ans : ");
                        String ans = sc.next();
                        Question qnew = new Question(question, optionA, optionB, optionC, optionD);
                        DLL.InsertAtLast(qnew);
                        CorrectAns.ENqueue(ans);
                        System.out.println("  Question Added Successfully   ");
                    }

                    break;
                case 2:
                    DLL.DISPLAY();
                    break;
                case 3:

                    CorrectAns.DisplaY();
                    break;
                case 4:
                    System.out.println("Enter which Questions answer u want to change");
                    int qstn=sc.nextInt();
                    System.out.println("Enter new answer");
                    String nans=sc.next();
                    CorrectAns.arr[qstn-1]=nans;
                    System.out.println(" ANSWER CHANGED SUCCESSFULLY !!");
                    break;
                case 5:
                    System.exit(0);
            }
            }
        }
    }
   static void InitialiseQuestion(){
        CorrectAns=new DoubleEndedQueue(10);
        Playersans=new DoubleEndedQueue(10);
       CorrectAns.ENqueue("C");
       CorrectAns.ENqueue("A");
       CorrectAns.ENqueue("C");
       CorrectAns.ENqueue("B");
       CorrectAns.ENqueue("D");
       CorrectAns.ENqueue("A");
       CorrectAns.ENqueue("D");
       CorrectAns.ENqueue("D");
       CorrectAns.ENqueue("A");
       CorrectAns.ENqueue("B");
       Question q1 = new Question("Q1> What is the Full-Form of R.T.O ?", "A) Regional transportation Operative", "B) Rural transportation Office", "C)Regional transport Office", "D) Regional transportation office");
       Question q2 = new Question("Q2> How many countries are present in the world ?", "A) 195", "B) 190", "C) 194", "D) 184");
       Question q3 = new Question("Q3> Who is the C.E.O of Goggle ?", "A) Jeff Bezos", "B) Mark ZuckerBug", "C) Sundar Pichai", "D) Bill gates");
       Question q4 = new Question("Q4> Who is the 1st Female president of India ?", "A)Indira gandhi", "B)Prathibha Patil", "C)Sonia Gandhi", "D)Lakshmi Sahgal");
       Question q5 = new Question("Q5> Who is the Current railway Minister of India?", "A)Mamta Banarjee", "B)Ram Vilash", "C)Piyush Goyal", "D)Ashwini Vaishnaw");
       Question q6 = new Question("Q6> Which city is know as Pink City in India?", "A)Jaipur", "B)Bangalore", "C)Gujarat", "D)Dehli");
       Question q7 = new Question("Q7> Who was the first Indian woman to win a medal in the Olympics?", "A)P.T.Usha", "B)Kunjarani Devi", "C)Bachendri Pal", "D)Karnam Maleshwarin");
       Question q8 = new Question("Q8) Which James Bond movie was shot in the Indian city of Udaipur?", "A)Diamonds Are Forever", "B)License to Kill", "C)Live and Let Die", "D)Octupussy");
       Question q9 = new Question("Q9> What does not grow on tree according to a popular Hindi saying?", "A)Money", "B)Flowers", "C)Leaves", "D)Fruits");
       Question q10 = new Question("Q10> When is the National Hindi Diwas celebrated?", "A)13 September", "B)14 September", "C)14 July", "D)15 August");
       DLL.InsertAtLast(q1);
       DLL.InsertAtLast(q2);
       DLL.InsertAtLast(q3);
       DLL.InsertAtLast(q4);
       DLL.InsertAtLast(q5);
       DLL.InsertAtLast(q6);
       DLL.InsertAtLast(q7);
       DLL.InsertAtLast(q8);
       DLL.InsertAtLast(q9);
       DLL.InsertAtLast(q10);
    }
   static  void Stud_info_details() {
        Scanner sc = new Scanner(System.in);
        System.out.print("PLEASE ENTER YOUR EMAIL-ID :");
        id = sc.nextLine();
        System.out.print("PLEASE ENTER YOUR NAME :");
        name = sc.nextLine();
        boolean check = true;
        System.out.print("PLEASE ENTER YOUR PHONE NUMBER :");
        do {
            num = sc.nextLine();
            int j = 0;
            for (int i = 0; i < num.length(); i++) {
                if (num.charAt(i) >= '0' && num.charAt(i) <= '9')
                    j++;
            }
            char c[] = num.toCharArray();
            for (char cc : c) {
                if (Character.isDigit(cc)) {
                    if (j == 10) {
                        check = false;
                    }
                }
            }
            if (check == true) {
                System.out.println("Enter valid number !!");
            }
        } while (check);

        System.out.println("Please Enter Your Password ");
        System.out.println("NOTE :\n 1)Password must be of length 8 to 15 \n 2)It must contain one upper case and one lower case character \n 3)Must contain 1 digit \n 4)Must contain symbol \n 5)Must not contain any space ");
        String pwd;
        boolean check2 = true;
        do {
            pwd = sc.nextLine();
            int upper = 0, lower = 0, digit = 0, space = 0, symbol = 0;
            if (pwd.length() >= 8 && pwd.length() <= 15) {
                for (int k = 0; k < pwd.length(); k++) {

                    if (pwd.charAt(k) >= 'A' && pwd.charAt(k) <= 'Z')
                        upper = 1;
                    if (pwd.charAt(k) >= 'a' && pwd.charAt(k) <= 'z')
                        lower = 1;
                    if (pwd.charAt(k) >= '0' && pwd.charAt(k) <= '9')
                        digit = 1;
                    if (pwd.charAt(k) == ' ')
                        space = 1;
                    if (!Character.isDigit(pwd.charAt(k)) && !Character.isWhitespace(pwd.charAt(k)) && !Character.isLetter(pwd.charAt(k)))
                        symbol = 1;

                }

            }
            if (upper == 1 && lower == 1 && digit == 1 && space == 0 && symbol == 1)
                check2 = false;
            if (check2 == true)
                System.out.println("Enter valid Password");

        } while (check2);
        String conpwd;
        boolean check3 = true;
        System.out.println("Confirm your  Password");
        do {
            conpwd = sc.nextLine();
            if (pwd.equals(conpwd))
                check3 = false;
            else
                System.out.println("Password did not match \nEnter your password again");

        } while (check3);
        System.out.println("CONGRATULATIONS  !! You have Registered successfully for the Quiz");
        Game();
    }


    static void Game () {
        Scanner sc = new Scanner(System.in);

        System.out.println("                                             Rules & Regulation          ");
        System.out.println("                       ---------------------------------------------------------------------------");
        System.out.println("                       1. You will have 10 Questions to answer.");
        System.out.println("                       2. Each question is of one mark which means the Quiz will be of total 10 marks.");
        System.out.println("                       3. You can either attempt a question or skip to next  question");
        System.out.println("                       4. Each question will have 4 options out of which 1 will be correct.");
        System.out.println("                       --------------------------------------------------------------------------");
        System.out.println("Are you ready to play the Quiz !? \n 1->PLAY \n 2->EXIT");
        int ch = sc.nextInt();
        if (ch == 2) {
            System.exit(0);
        } else {
            PlayQuiz();
        }
    }
    static void PlayQuiz () {
        int Marks = 0;
        int CorrectQ = 0, IncorrectQ = 0,SkipQ=0,QuestionA=0;
        Playersans = DLL.displayQuestion(Playersans);
        for (int i = 0; i < 10; i++) {
            if (Playersans.arr[i].equalsIgnoreCase(CorrectAns.arr[i])) {
                Marks = Marks + 1;
                QuestionA=QuestionA+1;
                CorrectQ = CorrectQ + 1;
            } else if (Playersans.arr[i].equalsIgnoreCase("null")){
                SkipQ=SkipQ+1;
            }
            else {
                QuestionA=QuestionA+1;
                IncorrectQ=IncorrectQ+1;
            }
        }
        System.out.println("                          -----------------------------------------------");
        System.out.println("                                            SCORECARD                    ");
        System.out.println("                          -----------------------------------------------");
        System.out.println("                           ~>Name   :"+name);
        System.out.println("                           ~>Email  :"+id);
        System.out.println("                           ~>Mobile :"+num);
        System.out.println("                          -----------------------------------------------");
        System.out.println("                          ~> Total Questions Attempted : "+ QuestionA);
        System.out.println("                          ~> Correct answers           : "+CorrectQ);
        System.out.println("                          ~> Incorrect answers         : "+IncorrectQ);
        System.out.println("                          ~> Questions Skipped         : "+SkipQ);
        System.out.println("                          ~> Percentage                : "+CorrectQ*10);
        System.out.println("                          -----------------------------------------------");
        System.out.println("        DO YOU WISH TO SEE THE CORRECT ANSWERS FOR YOUR INCORRECT ANSWER ?(1-YES 2-NO) ");
        int yn=sc.nextInt();
        if(yn==1){
            for(int i=0;i<10;i++){
                if(!(Playersans.arr[i].equalsIgnoreCase(CorrectAns.arr[i])) && !(Playersans.arr[i].equalsIgnoreCase("null"))){
                    System.out.print("   YOUR ANSWER FOR Q"+(i+1)+" : ");
                    System.out.println(Playersans.arr[i]);
                    System.out.print("CORRECT ANSWER FOR Q"+(i+1)+" : ");
                    System.out.println(CorrectAns.arr[i]);
                    System.out.println();
                    System.out.println();
                }
            }
        }
        try{
            Thread.sleep(6000);
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println("                       ---------            ");
        System.out.println("                        THANK YOU            ");
        System.out.println("                       ---------            ");
    }

}
class DoubleLinkList {
    Scanner sc = new Scanner(System.in);
    class node {
        Question data;
        node next;
        node prev;

        node(Question data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    node first = null;
    void InsertAtLast(Question data) {
        node n = new node(data);
        if (first == null) {
            first = n;
        } else if (first.next == null) {
            n.prev = first;
            first.next = n;

        } else {
            node vc = first;
            do {
                vc = vc.next;
            } while (vc.next != null);
            n.prev = vc;
            vc.next = n;
        }
    }
    DoubleEndedQueue displayQuestion(DoubleEndedQueue ansQueue){
        node temp=first;
         String ans = null;
        while (temp!=null){
            boolean b=true;
            while (b){
                System.out.println(temp.data);
                if(temp==first){
                    System.out.println("2->NEXT QUESTION");
                } else if (temp.next==null) {
                    System.out.println("1->PREVIOUS QUESTION");
                }
                else {
                    System.out.println("1->PREVIOUS QUESTION");
                    System.out.println("2->NEXT QUESTION");
                }
                System.out.print("ANS :");
                ans=sc.next();
                if((ans.equalsIgnoreCase("A")||ans.equalsIgnoreCase("B")||ans.equalsIgnoreCase("C")||ans.equalsIgnoreCase("D"))){
                    b=false;
                }
                else if (ans.equalsIgnoreCase("1")) {
                    temp=temp.prev;
                    ansQueue.DELETE_FROM_REAR();
                } else if (ans.equalsIgnoreCase("2")) {
                    ansQueue.ENqueue("null");
                    temp = temp.next;
                }else {
                    System.out.println("Enter correct option");
                }
            }
            ansQueue.ENqueue(ans);
            ansQueue.DisplaY();
             temp=temp.next;
        }
        return ansQueue;
    }
    void DISPLAY(){
        node temp=first;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    void DeleteValue(Question value){
        int flag=0;
        node vc=first;
        while(vc!=null){
            if(vc.data==value){
                flag=1;
            }
            vc=vc.next;
        }
        if(flag==0){
            System.out.println("no value found");
        }
        else{
            if(first.data==value){
                first=null;
            }
            else{
                node temp=first;
                while(temp.data!=value){
                    temp=temp.next;
                }
                if(temp.next==null){
                    DeleteAtLast();
                }
                else{
                    temp.prev.next=temp.next;
                    temp.next.prev=temp.prev;
                    temp.next=null;
                    temp.prev=null;
                }

            }
        }
    }
    void DeleteAtLast(){
        if(first==null){
            System.out.println("MT");
        }
        else {
            node temp=first;
            while (temp.next!=null){
                temp=temp.next;
            }
            temp.prev.next=null;
            temp.prev=null;
        }
    }
}
class Question{
    String OptionA;
    String OptionB;
    String OptionC;
    String OptionD;
    String Question;
    Question(String Question,String optionA,String optionB,String optionC,String optionD){
        this.OptionA=optionA;
        this.OptionB=optionB;
        this.OptionC=optionC;
        this.OptionD=optionD;
        this.Question=Question;
    }
    public String getOptionC() {
        return OptionC;
    }
    public String getOptionD() {
        return OptionD;
    }
    public String getOptionA() {
        return OptionA;
    }
    public String getOptionB() {
        return OptionB;
    }
    public String getQuestion() {
        return Question;
    }
    @Override
    public String toString() {
        System.out.println(getQuestion());
        System.out.println(getOptionA());
        System.out.println(getOptionB());
        System.out.println(getOptionC());
        System.out.println(getOptionD());
        return "";
    }
}
class DoubleEndedQueue {
    int f,r,capacity;
    String [] arr;
    DoubleEndedQueue(int size){
        capacity=size;
        f=r=-1;
        arr=new String[capacity];
    }
    void ENqueue(String x){
        if(f==0&&r==capacity-1||f==r+1){
            System.out.println("Stack overflow!");
        }
        else{
            if(f==-1){
                f++;
            }

            r=(r+1)%capacity;
            arr[r]=x;
        }
    }
    void DisplaY(){
        if(f==-1){
            System.out.println("EMPTY");
        }
        else{
            int i=f;
            do{
                System.out.println("ANS"+(i+1)+"-->"+arr[i]);
                i=(i+1)%capacity;
            }while(i!=(r+1)%capacity);
        }

    }
    void DELETE_FROM_REAR(){
        if(f==-1){
            System.out.println("EMPTY");
        }
        else{
            if(f==r){

                f=r=-1;
            }
            else if(r==0){

                r=capacity-1;
            }
            else{

                r--;
            }
        }
    }
}