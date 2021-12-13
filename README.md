# Android-Hyebin
![github_이혜빈_ver1-25](https://user-images.githubusercontent.com/70698151/135754518-b0b65ab0-5cd6-45e6-8ce9-4b307a36e278.png) 

<br><br><br>

<details>
<summary>1주차</summary>
  
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
</details>

<details>
<summary>2주차</summary>
  
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

<br><br><br><br><br>
  </details>
  
<details>
<summary>3주차</summary>
  
# 3️⃣ Third Week

|SignUp|SignIn|Profile|Home|ViewPager|
|---|---|---|---|---|
|![ezgif com-gif-maker (6)](https://user-images.githubusercontent.com/69586104/139569164-e49e2022-49ec-44a1-a9c9-175248f5ae29.gif)| ![ezgif com-gif-maker (7)](https://user-images.githubusercontent.com/69586104/139569185-bf83c8f8-820f-4b66-b505-592578b36859.gif)|![ezgif com-gif-maker (8)](https://user-images.githubusercontent.com/69586104/139569193-df9a7f96-64d3-4962-8bae-140a659571a7.gif)|![ezgif com-gif-maker (9)](https://user-images.githubusercontent.com/69586104/139569199-8367e45a-faca-4e24-9049-e147d65f724a.gif)|![ezgif com-gif-maker (10)](https://user-images.githubusercontent.com/69586104/139569210-96a0630e-680b-494c-a4a3-dadb42c389fc.gif)|


<br><br>

## LEVEL1

<br><br>

**1-1. EditText에 selector 활용하기**


```kotlin
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:drawable="@drawable/et_border_pink" android:state_focused="true"/>
    <item android:drawable="@drawable/et_fill_gray" android:state_focused="false"/>
</selector>
```

<br><br>

**1-2. 버튼 등등 Drawable로 직접 만들기**

```kotlin
<shape xmlns:android="http://schemas.android.com/apk/res/android"
    android:shape="rectangle">
    <solid android:color="@color/pink"/>
    <corners
        android:bottomRightRadius="5dp"
        android:bottomLeftRadius="5dp"
        android:topLeftRadius="5dp"
        android:topRightRadius="5dp"/>
```

<br><br>

✍Button에 selector 활용하기는 위의 EditText에 selector 활용하기와 같은 방식으로 코드를 작성했습니다! 

<br>

**2-1. 이미지 Glide의 CircleCrop 기능을 활용해서 넣어주기**

```kotlin
 Glide.with(this)
            .load("https://mblogthumb-phinf.pstatic.net/MjAxOTA0MjNfMjcy/MDAxNTU2MDIwNjg0ODMw.KwUiIDMhdpKzsuNX83GpdFljS1HjgNhCBNcXv2QXfxkg.ksHQVjDUTn8AMV4XVSfETLX-tZ1LTz9-bOmO0o7AtI8g.JPEG.ndh7782/%EC%B9%98%EC%A6%8801.JPG?type=w800")
            .apply(RequestOptions.circleCropTransform())
            .into(binding.ivProfile)

```

<br><br>



**2-2. 아이콘 이미지 export해서 사용**

```kotlin
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/menu_profile"
        android:icon="@drawable/ic_person_gray"
        android:title="프로필" />

    <item
        android:id="@+id/menu_home"
        android:icon="@drawable/ic_home_gray"
        android:title="홈" />

    <item
        android:id="@+id/menu_camera"
        android:icon="@drawable/ic_camera_gray"
        android:title="카메라" />
</menu>
```

<br><br>

**2-3. 하단에 BottomNavigation 넣어주기**
  
```kotlin
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNavigationView"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="@color/white"
        app:menu="@menu/menu_bottom"
        app:itemIconTint="@drawable/selector_icon"
        app:itemTextColor="@drawable/selector_icon"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent" />
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

**3-1 TabLayout + ViewPager2**

```kotlin
 <com.google.android.material.tabs.TabLayout
        android:id="@+id/tl_follow"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="200dp"
        android:fontFamily="@font/noto_sans_kr_regular"
        android:textFontWeight="500"
        android:textSize="16sp"
        app:tabIndicatorColor="@color/pink"
        app:tabIndicatorHeight="3dp"
        app:tabSelectedTextColor="@color/pink"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

    </com.google.android.material.tabs.TabLayout>

    <androidx.viewpager2.widget.ViewPager2
        android:id="@+id/vp_follow"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_marginTop="13dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/tl_follow" />

```

<br>

## LEVEL2-2

<br><br>

**FollowerAdapter**

```kotlin
 Glide.with(itemView.context).load(data.photo)
                .apply(RequestOptions.circleCropTransform())
                .into(binding.ivProfile)
```
<br><br>

**FollowerData**

```kotlin
data class FollowerData(
    val name: String,
    val introduction: String,
    val photo : String
)
```

<br><br>

**FollowerFragment**

```kotlin
 follwerAdapter.userList.addAll(
            listOf(
                FollowerData("스폰지밥", "안녕하세요", "https://ww.namu.la/s/bd52223e4d1f11fcc4c7f6506bf3321b26579bf118db6c1ca20492b9af4228a414edd25f1006baace220e4ca771288e0f38d6cbf253ae4e9d39aaf4b881600b0d65e518e7d94891837ee9a0c6a723aac0f4d2b7bf4a65b36bd1fe636aa49c632"),
                FollowerData("뚱이", "안녕하세요", "https://img.insight.co.kr/static/2020/08/12/700/fyzvinle3b068ce501hq.jpg"),
                FollowerData("집게사장", "안녕하세요", "https://pbs.twimg.com/media/D8RITHlV4AAb1iG.jpg")
            )
        )
```


<br><br><br><br>
*** 
<br>

**🤍이번 과제를 통해 배운 내용 & 성장한 내용🤍**

<br>

**☝디자인을 적용하는 방법을 익혔습니다**
<br>
초기에 직접 레이아웃을 짰을 때와 디자이너분께서 디자인해주는 것을 보며 수정을 해나가면서 나오는 결과물의 차이를 보고 디자이너의 중요성과 협업의 중요성을 깨달을 수 있는 계가기 되었습니다.
<br>
또한, 피그마를 제대로 다뤄본 적이 한번도 없었는데, 협업에 있어서 피그마를 쓰는 법을 익힐 수 있었습니다.
<br><br>

**✌ViewPager2를 이해했습니다**
<br>
어플을 사용하면서 가장 많이 봤던 기능 중 하나였는데, 이번 세미나를 통해 ViewPager2를 알 수 있었습니다.
<br>
또한, TabLayout등등도 함께 배울 수 있어서 뜻깊었습니다.

<br><br><br>

  </details>
  
  <details>
<summary>4주차</summary>
# 4️⃣ Fourth Week

|LogIn|
|---|
|![ezgif com-gif-maker (11)](https://user-images.githubusercontent.com/69586104/141409725-87a1f71e-faee-4aef-9326-6f4190bfc721.gif)|


<br><br>

## LEVEL1

<br><br>

**PostMan 테스트 이미지 첨부**
|POST|GET|
|---|---|
|![POST](https://user-images.githubusercontent.com/69586104/141409267-67df1f29-f08a-4c3e-b238-848bb282991d.png)|![조회](https://user-images.githubusercontent.com/69586104/141409462-16d10017-da44-4ffe-a2a1-d9ac608c070c.png)

<br><br>

**RequestData**


```kotlin
data class RequestLoginData(
    @SerializedName("email")
    val email: String,
    val password: String
)

data class RequestSignUpData(
    @SerializedName("email")
    val email: String,
    val name: String,
    val password: String
)
```

<br><br>

**ResponseData**

```kotlin
data class ResponseLoginData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int,
        val name: String,
        val email: String
    )
}


data class ResponseSignUpData(
    val status: Int,
    val success: Boolean,
    val message: String,
    val data: Data
) {
    data class Data(
        val id: Int,
        val name: String,
        val email: String
    )
}
```

<br><br>


**SampleService**

```kotlin
interface SampleService {
    @Headers("Content-Type: application/json")
    @POST("user/login")
    fun postLogin(
        @Body requestLoginData: RequestLoginData
    ) : Call<ResponseLoginData>
}

interface SignUpService {
    @Headers("Content-Type: application/json")
    @POST("user/signup")
    fun postSignUp(
        @Body requestSignUpData: RequestSignUpData
    ) : Call<ResponseSignUpData>
}
```

<br><br>



**ServiceCreator**

```kotlin
<menu xmlns:android="http://schemas.android.com/apk/res/android">
object ServiceCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val sampleService : SampleService = retrofit.create(SampleService::class.java)
}


object SignUpCreator {
    private const val BASE_URL = "https://asia-northeast3-we-sopt-29.cloudfunctions.net/api/"

    private val retrofit: Retrofit = Retrofit
        .Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val signUpService : SignUpService = retrofit.create(SignUpService::class.java)
}
```

<br><br>

**SignInActivity**
  
```kotlin
 private fun initNetwork() {
        val requestLoginData = RequestLoginData(
            binding.etId.text.toString(),
            binding.etPassword.text.toString()
        )

        val call : Call<ResponseLoginData> = ServiceCreator.sampleService.postLogin(requestLoginData)
        call.enqueue(object : Callback<ResponseLoginData> {
            override fun onResponse(
                call: Call<ResponseLoginData>,
                response: Response<ResponseLoginData>
            ) {
                if(response.isSuccessful) {
                    Toast.makeText(this@SignInActivity, "${response.body()?.data?.name}님 반갑습니다", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignInActivity,HomeActivity::class.java))
                } else {
                    Toast.makeText(this@SignInActivity, "로그인에 실패했습니다", Toast.LENGTH_SHORT).show()
                }

            }

            override fun onFailure(call: Call<ResponseLoginData>, t: Throwable) {
                Log.e("NetworkTest", "error: $t")
            }

        })
    }
```

<br><br>


**SignUpActivity**
```kotlin
 private fun initNetwork() {
        val requestSignUpData = RequestSignUpData(
            binding.etName.text.toString(),
            binding.etId.text.toString(),
            binding.etPassword.text.toString()
        )

        val call : Call<ResponseSignUpData> = SignUpCreator.signUpService.postSignUp(requestSignUpData)
        call.enqueue(object : Callback<ResponseSignUpData> {
            override fun onResponse(
                call: Call<ResponseSignUpData>,
                response: Response<ResponseSignUpData>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(this@SignUpActivity, response.body()?.message, Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this@SignUpActivity, "회원가입 실패", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseSignUpData>, t: Throwable) {
                Log.e("NetworkTest", "error: $t")
            }
        })
    }
```


<br><br><br><br>
*** 
<br>

**🤍이번 과제를 통해 배운 내용 & 성장한 내용🤍**

<br>

**☝서버를 익혔습니다**
<br>
서버가 뭔지 정말 하나도 모르고 다 처음 보는 코드와 개념 투성이어서 조금은 어렵게 느껴졌었습니다 😥
<br>
그래도! 실습과 과제를 통해... 아주 조금은.. 이해를 한 것 같다는 생각이 듭니다!
<br>
더 복습하고 공부하면서 제대로 이해하고 넘어가겠습니다!


<br><br><br>
</details>

<details>
<summary>7주차</summary>
      
# 7️⃣ Seventh Week

|onBoarding|autoLogin|autoLogin cancel|
|---|---|---|
|![ezgif com-gif-maker (12)](https://user-images.githubusercontent.com/69586104/145872035-8f9485f8-569e-40dd-9c3f-4d5f62269e3b.gif)|![ezgif com-gif-maker (13)](https://user-images.githubusercontent.com/69586104/145872089-8065230c-4060-49ff-9515-47776dd77a83.gif)|![ezgif com-gif-maker (14)](https://user-images.githubusercontent.com/69586104/145872131-05ba9313-073c-4a5d-a398-05fc93530b04.gif)

<br><br>

## LEVEL1

<br><br>

🤍view는 notion을 참고하여 제작했습니다🤍
      
<br>
  
**1-1. 온보딩 화면 만들기**
  
<br>
  
**nav_onboarding.xml**


```kotlin
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_onboarding"
    app:startDestination="@id/onboardingFragment1">

    <fragment
        android:id="@+id/onboardingFragment1"
        android:name="com.example.myapplication.view.onboarding.OnboardingFragment1"
        android:label="fragment_onboarding1"
        tools:layout="@layout/fragment_onboarding1" >
        <action
            android:id="@+id/action_onboardingFragment1_to_onboardingFragment2"
            app:destination="@id/onboardingFragment2" />
    </fragment>

    <fragment
        android:id="@+id/onboardingFragment2"
        android:name="com.example.myapplication.view.onboarding.OnboardingFragment2"
        android:label="OnboardingFragment2" >
        <action
            android:id="@+id/action_onboardingFragment2_to_onboardingFragment3"
            app:destination="@id/onboardingFragment3" />
    </fragment>

    <fragment
        android:id="@+id/onboardingFragment3"
        android:name="com.example.myapplication.view.onboarding.OnboardingFragment3"
        android:label="OnboardingFragment3">
        <action
            android:id="@+id/action_onboardingFragment3_to_signInActivity"
            app:destination="@id/signInActivity" />
    </fragment>
    <activity
        android:id="@+id/signInActivity"
        android:name="com.example.myapplication.view.login.SignInActivity"
        android:label="activity_main"
        tools:layout="@layout/activity_signin" />
</navigation>
```

<br><br>

**OnboardingFragment1**
  
<br>
  
각 프레그먼트별로 buttonEvent를 생성했습니다

  <br>

```kotlin
fun initBtnEvent() {
        binding.btnNext.setOnClickListener {
            findNavController().navigate(R.id.action_onboardingFragment1_to_onboardingFragment2)
        }
    }
```

<br><br>

**1-2. SharedPreferences 활용해서 자동로그인/자동로그인 해제**
      
<br>
      
**activity_cancel_auto_login**

```kotlin
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".view.profile.CancelAutoLoginActivity">

    <androidx.constraintlayout.widget.ConstraintLayout
        android:background="@color/pink"
        android:id="@+id/constraintLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent">

        <TextView
            android:id="@+id/tv_setting"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginStart="20dp"
            android:layout_marginTop="30dp"
            android:layout_marginBottom="30dp"
            android:fontFamily="@font/noto_sans_kr_regular"
            android:text="환경설정"
            android:textColor="@color/white"
            android:textFontWeight="800"
            android:textSize="30sp"
            app:layout_constraintBottom_toBottomOf="parent"
            app:layout_constraintStart_toStartOf="parent"
            app:layout_constraintTop_toTopOf="parent" />


    </androidx.constraintlayout.widget.ConstraintLayout>


    <TextView
        android:id="@+id/tv_off_auto_login"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginStart="20dp"
        android:layout_marginTop="20dp"
        android:fontFamily="@font/noto_sans_kr_regular"
        android:text="자동로그인 해제"
        android:textColor="@color/maingray"
        android:textFontWeight="400"
        android:textSize="18sp"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/constraintLayout" />

    <LinearLayout
        android:id="@+id/ll_line"
        android:layout_width="match_parent"
        android:layout_height="2dp"
        android:layout_marginTop="20dp"
        android:background="@color/lightgray"
        android:orientation="horizontal"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintHorizontal_bias="0.0"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/tv_off_auto_login" />


</androidx.constraintlayout.widget.ConstraintLayout>
```

<br><br>


**SiginInActivity**
  
```kotlin
private fun initClickEvent() {
    binding.ivAutoLogin.setOnClickListener {
        binding.ivAutoLogin.isSelected = !binding.ivAutoLogin.isSelected
            SOPTSharedPreferences.setAutoLogin(this, binding.ivAutoLogin.isSelected)
        }
    }

private fun isAutoLogin() {
    if(SOPTSharedPreferences.getAutoLogin(this)) {
         shortToast("자동로그인 완료")
         startActivity(Intent(this, HomeActivity::class.java))
         finish()
    }
}
```

<br><br>

**CancelAutoLoginActivity**
  
```kotlin
private fun initClickEvent() {
    binding.tvOffAutoLogin.setOnClickListener {
        val settings: SharedPreferences = getSharedPreferences("USER_AUTH", MODE_PRIVATE)
        val editor: SharedPreferences.Editor = settings.edit()
        editor.remove("int")
        editor.clear()
        editor.commit()
    }
}
```
<br><br>
  
**1-3 본인이 사용하는 Util 클래스 코드 및 패키징 방식**
<br>
  util에서는 세미나 시간에 다룬 shortToast를 정의해둔 상태입니다. 
  <br>
  자주 사용하는 토스트 메시지 기능을 클래스로 만들어 여러 곳에서 사용할 수 있었습니다.
<br>
  ```kotlin
fun Context.shortToast(message: String) {
    Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
}
```
  
<br>
  - 패키징 방식
  <br>
    -자주 생성되는 클래스인 adapter, api, data, util, view를 중심으로 하여 패키지를 나눴습니다.
  
 ┣ 📂adapter
  <br>
 ┣ 📂api
  <br>
 ┣ 📂data
  <br> 
 ┣ 📂util
  <br>
 ┗ 📂view
  <br>
  
    ┣ 📂camera
  
    ┣ 📂home
  
    ┣ 📂login
  
    ┣ 📂onboarding
    
    ┗ 📂profile
<br><br><br><br>
*** 
<br>

**🤍이번 과제를 통해 배운 내용 & 성장한 내용🤍**

<br>

**☝navigation**
<br>
보통 어플을 실행했을때 자주 접했던 온보딩 화면을 만들 수 있는 기회라서 뜻깊고 앞으로 많이 활용될 것 같아 굉장히 많이 배운 것 같습니다.
  <br>
  <br>

  
**✌util에 대해 이해했습니다**
<br>
  항상 자주 사용하는 부분에서 꼭 저렇게 써야하나라는 것을 많이 생각했는데, 이번 세미니와 과제를 통해 util을 배우고, 반복되는 코드를 단순화 할 수 있는 기회가 되었습니다.
<br>
<br>
  
**👌package기능에 대해 이해했습니다**
<br>
클래스가 너무 많아서 이제 뭐가 뭔지 헷갈리기 시작했는데, 이때 딱 패키징에 대해서 배우고 활용해보는 기회가 되었습니다! 앞으로 제가 정의한 패키징 방식에 따라 사용하면 나중에도 보다 프로젝트를 관리하기 좋을 것 같다는 생각이 들었습니다.
<br>
  


<br><br><br>
</details>

