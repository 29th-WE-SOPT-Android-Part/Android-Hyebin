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



<br><br><br><br><br>

# 2️⃣ Second Week

|Home|
|---|
|![ezgif com-gif-maker (5)](https://user-images.githubusercontent.com/69586104/138444148-fa9b689b-10ec-4559-ba0c-3bf935d4707f.gif)|


<br><br>


🙏FollowerRecyclerView와 RepositoryRecyclerView의 코드가 유사하므로 FollowerRecyclerView 구현코드만 작성하겠습니다.🙏

<br>

## LEVEL1

<br><br>

**1. FollowerRecyclerView**

<br>

+) LinearLayoutManager 사용 ( GridLayoutManage관련 코드는 하단에 첨부하겠습니다. ) 

```kotlin
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_follower"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.LinearLayoutManager"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="1.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:layout_constraintVertical_bias="0.0"
        tools:itemCount="4"
        tools:listitem="@layout/item_follower_list" />
```

<br><br>

**2. FolloweData**

```kotlin
data class FollowerData(
    val name: String,
    val introduction: String
)
```

<br><br>

**3. FollowrAdapter**

```kotlin
class FollowerAdapter : RecyclerView.Adapter<FollowerAdapter.FollowerViewHolder>() {
    val userList = mutableListOf<FollowerData>()

    class FollowerViewHolder(private val binding : ItemFollowerListBinding) : RecyclerView.ViewHolder(binding.root){
        fun onBind(data: FollowerData) {
            binding.tvName.text = data.name
            binding.tvIntroduction.text = data.introduction
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FollowerViewHolder {
        val binding = ItemFollowerListBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return FollowerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FollowerViewHolder, position: Int) {
        holder.onBind(userList[position])
    }

    override fun getItemCount(): Int = userList.size
}

```

<br><br>



**FollowerFragment**

```kotlin
class FollowerFragment : Fragment() {
    private lateinit var follwerAdapter: FollowerAdapter
    private var _binding: FollowerFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FollowerFragmentBinding.inflate(layoutInflater, container,false)

        follwerAdapter = FollowerAdapter()
        binding.rvFollower.adapter = follwerAdapter

        follwerAdapter.userList.addAll(
            listOf(
                FollowerData("이혜빈1", "안녕하세요"),
                FollowerData("이혜빈2", "안녕하세요"),
                FollowerData("이혜빈3", "안녕하세요"),
                FollowerData("이혜빈4", "안녕하세요")
            )
        )
        follwerAdapter.notifyDataSetChanged()
        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
```

<br><br>

**HomeActivity**
  
```kotlin
class HomeActivity : AppCompatActivity() {
    private var postion = FIRST_POSITION
    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initTransactionEvent()
    }

    fun initTransactionEvent() {
        val followerFragment = FollowerFragment()
        val repositstoryFragment = RepositoryFragment()

        supportFragmentManager.beginTransaction().add(R.id.container_rv, followerFragment).commit()

        binding.btnFollower.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container_rv, followerFragment) .commit()
        }

        binding.btnRepository.setOnClickListener {
            supportFragmentManager.beginTransaction().replace(R.id.container_rv, repositstoryFragment) .commit()
        }
    }


    companion object {
        const val FIRST_POSITION = 1
    }

}
```

<br><br>


**xml ellipsize 속성**
```kotlin
<TextView
        android:id="@+id/tv_content"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="8dp"
        android:textColor="@color/black"
        android:textSize="12sp"
        android:ellipsize="end"
        android:maxLines="1"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/tv_title"
        tools:text="내용" />
```

<br><br>

**RepositoryRecyclerView 속성**
<br>
+)GridlayoutManager 사용

```kotlin
    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv_repository"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:layoutManager="androidx.recyclerview.widget.GridLayoutManager"
        app:spanCount="2"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        tools:itemCount="4"
        android:layout_marginLeft="55dp"
        android:layout_marginRight="30dp"
        android:layout_marginTop="10dp"
        tools:listitem="@layout/item_repository_list" />

```

<br>

## LEVEL2-2

<br>
시험기간이라.. 2-2만 구현했습니다.. 다른 부분은 차차 해보겠습니다...

<br><br>

**Decoration**

```kotlin
   class Decoration(val colorString: String, val left: Int, val right: Int, val height: Int, val bottom:Int) : RecyclerView.ItemDecoration() {
    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)

        val paint = Paint().apply {
            color = Color.parseColor(colorString)
        }

        for (i in 0 until parent.childCount) {
            val child = parent.getChildAt(i)
            if (i != parent.childCount - 1) {
                c.drawRect(child.left.toFloat(), child.bottom.toFloat(), child.right.toFloat(), child.bottom.toFloat() + height, paint)
            }
        }
    }
    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = right
        outRect.left = left
        outRect.top = height
        outRect.bottom = height
    }
}

```
<br><br>

**FollowerFragment**

```kotlin
binding.rvFollower.addItemDecoration(Decoration("#F658A6", 50,50,25,25))
```

<br><br><br><br>
*** 
<br>

**🤍이번 과제를 통해 배운 내용 & 성장한 내용🤍**

<br>

**☝Fragment에 대해 이해했습니다.**
<br>
실습 예제만 따라하고 직접 원하는 요소를 살려서 구현은 해본 적이 없었는데, 이번 기회를 통해 직접 코드를 작성하면서 제대로 이해할 수 있는 시간을 가졌습니다.
<br>
그리고 fragment에서 binding을 사용하는 법 또한 익힐 수 있었습니다. 생명주기를 제대로 이해하지 못했는데 이번 기회를 통해 제대로 이해할 수 있게 되었습니다.
<br><br>

**✌ItemDecoration을 알게 되었습니다.**
<br>
원래 xml에서 margin값을 모두 줬는데, 이번 과제를 통해 ItemDecoration을 처음 알게되었습니다.
<br>
그래서 제가봐도 아직 부족하고.. 이상한.. 코드지만 더 열심히 공부해서.. 다음주에 더 나은 코드로 바꿔오겠습니다

<br><br><br>

