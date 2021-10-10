# Android-Hyebin
![github_이혜빈_ver1-25](https://user-images.githubusercontent.com/70698151/135754518-b0b65ab0-5cd6-45e6-8ce9-4b307a36e278.png) 

<br><br><br>
# 1️⃣ First Week

|SignIn|Login|Home|SignUp|
|---|---|---|---|
|![ezgif com-gif-maker](https://user-images.githubusercontent.com/69586104/136684197-a3f800e8-0c45-408a-b972-aa521b508674.gif)|![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/69586104/136684208-af155ede-b430-47ca-994f-2ed212b1c3a8.gif)|![ezgif com-gif-maker (2)](https://user-images.githubusercontent.com/69586104/136684214-f2df8ce7-8333-44b0-ba88-6172f70f663b.gif)|![ezgif com-gif-maker (3)](https://user-images.githubusercontent.com/69586104/136684221-7a219180-a466-4135-806b-fa699022ff02.gif)|


<br><br><br>

**1. SignUp**
  + 아이디, 비밀번호 입력이 모두 되었을 때만 로그인 버튼 눌렀을 때 HomeActivity로 이동 (토스트메시지 출력)
  
```kotlin
val intentHome = Intent(this, HomeActivity::class.java)

binding.apply {
     btnLogin.setOnClickListener {
         val userId : String = etId.text.toString()
         val userPw : String = etPassword.text.toString()
         if (userId.isNotEmpty() && userPw.isNotEmpty()) {
             startActivity(intentHome)
             Toast.makeText(this@SignInActivity, "$userId 님 환영합니다", Toast.LENGTH_SHORT).show()
         } else {
              Toast.makeText(this@SignInActivity, "로그인 실패", Toast.LENGTH_SHORT).show()
         }
     }
 }
```

<br><br>
  + 회원가입 버튼 눌렀을 때 화면 이동
  
```kotlin
val intentSingUp = Intent(this, SignUpActivity::class.java)
        
btnSignup.setOnClickListener {
    startActivity(intentSingUp)
    finish()
}
```

<br><br>
  + 회원가입에 성공한 뒤, 아이디&패스워드 자동 입력
  
```kotlin
if (intent.hasExtra("id") && intent.hasExtra("pw")) {
    val id = intent.getStringExtra("id")
    val pw = intent.getStringExtra("pw")

    etId.setText(id)
    etPassword.setText(pw)
}
```

<br><br>

  + EditText의 hint 속성 및 비밀번호의 inputType 속성
  

```kotlin
<EditText
    android:id="@+id/et_password"
    android:layout_width="0dp"
    android:layout_height="50dp"
    android:layout_marginStart="40dp"
    android:layout_marginTop="10dp"
    android:layout_marginEnd="40dp"
    android:background="@drawable/et_border_pink"
    android:ems="10"
    android:hint="비밀번호를 입력해주세요"
    android:textSize="15dp"
    android:paddingStart="20dp"
    android:inputType="textPassword"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/tv_password" />
```
<br><br><br>

**2. Home**
  + Home 버튼 누르면 나의 git 페이지로 이동 (암시적 인텐트)
```kotlin
binding.btnGit.setOnClickListener{
    var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/lhb8106"))
    startActivity(intent)
}
```
<br>

**✅명시적 인텐트와 암시적 인텐트의 차이점✅**
<br><br>
명시적 인텐트는 실행하고자하는 컴포넌트가 명확할 때 사용하는 방식입니다. 즉, 패키지 내부의 액티비티를 실행할 때 사용됩니다.<br>
암시적 인텐트는 어떠한 인텐트를 담아서 보내면, 시스템이 적절한 컴포넌트를 찾아서 실행해주는 방식입니다.

<br><br>

  + 사진 비율 맞추기
```kotlin
 <ImageView
     android:id="@+id/iv_profile"
     android:layout_width="180dp"
     android:layout_height="0dp"
     android:layout_marginTop="20dp"
     android:src="@drawable/selca"
     app:layout_constraintDimensionRatio="1:1"
     app:layout_constraintEnd_toEndOf="parent"
     app:layout_constraintStart_toStartOf="parent"
     app:layout_constraintTop_toTopOf="parent" />
```
<br><br>

  + 스크롤뷰 적용
```kotlin
<ScrollView
    android:id="@+id/scroll"
    android:layout_width="0dp"
    android:layout_height="0dp"
    android:layout_marginTop="20dp"
    android:layout_marginBottom="20dp"
    android:fillViewport="true"
    app:layout_constraintBottom_toBottomOf="parent"
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toBottomOf="@+id/tv_title">
</ScrollView>
```
<br><br><br>
  
**3. SignIn**
  + 회원가입 완료 버튼 눌렀을 때, 빈칸 확인 및 아이디, 비밀번호 값 넘겨주기
```kotlin
val intent = Intent(this, SignInActivity::class.java)

binding.apply {
    btnSingup.setOnClickListener {
        val userName : String = etName.text.toString()
        val userId : String = etId.text.toString()
        val userPw : String = etPassword.text.toString()

         if (userName.isNotEmpty() && userId.isNotEmpty() && userPw.trim().isNotEmpty()) {
                    intent.putExtra("id", userId)
                    intent.putExtra("pw", userPw)
                    startActivity(intent)
                    finish()

         } else {
             Toast.makeText(this@SignUpActivity, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
         }
     }
  }
```

<br><br>
  + hint 속성 및 inputType 속성은 위의 SignUp과 같습니다.

<br><br><br><br>
*** 
<br>

**🤍이번 과제를 통해 배운 내용 & 성장한 내용🤍**

<br>
**☝constraintlayout을 정확히 이해했습니다!** 
<br>
지금까지 안드로이드 스튜디오에서 LinearLayout을 주로 사용하고, ConstraintLayout을 제대로 활용해본 경험이 없었는데, 
이번 과제와 세미나를 통해 ConstraintLayout을 제대로 이해하고 활용할 수 있는 방법을 알게 되었습니다.
<br>
그 외에도 layout 내에서 쓸 수 있는 다양한 속성을 익힐 수 있었습니다. (inputType 속성 & constraintDimensionRatio 속성)
<br><br>

**✌intent를 이해할 수 있는 기회가 되었습니다!** 
<br>
처음에는 잘 이해가 되지 않았지만, 여러번 화면을 이동하는 연습을 하다보니, intent를 사용하는 방법과 활용 방안에 대해서 잘 익힐 수 있는 기회가 되었습니다.
<br>
하지만 hasExtra는 아직은..잘 모르겠네요.. 얼렁뚱당 의도대로 움직이긴 하지만 더 정확한 코드를 작성하고 싶습니다.
<br><br>

**👌git과 notion**
<br>
git을 다루는 방법을 하나도 모르는 사람이었는데, 이번에 과제를 제출하기 위해 유튜브도 찾아보고 많은 사람들에게 물어보며 공부를 했습니다.. <br>
아직 배워야할 점이 산더미이지만 차근차근 올라가서 나중에는 꼭 깃 마스터가 되겠습니다..❗ <br>
그리고 notion을 솝트 들어와서 처음 알게 되었다보니, 자료 하나 찾는데에도 꽤 많은 시간을 소모했습니다. <br>
하지만 자주 들어가서 정보를 확인하다보니 notion이 점점 어렵지 않게 느껴집니다! <br>
노션과 깃.. 차차 친해지겠습니다💗
<br><br><br>
