# Docfriends_Android_Recruit

닥프렌즈 Android 개발 채용 과제 결과물입니다.

## 1. 구현기능
- 홈 화면
- Paging3 라이브러리를 사용한 Pagination 처리
- CoodinatorLayout을 통한 Scroll Animation
- Dark Theme 구현
- Loading 상태 표시
- 네트워크 장애 시 안내 문구 출력

## 2. 미리보기
- 홈 화면  
  <img src="https://user-images.githubusercontent.com/47319426/134714892-f6f114c0-5767-4e27-961f-dbc8c4f32575.jpg" width="300">

- 아래로 스크롤된 홈 화면  
  <img src="https://user-images.githubusercontent.com/47319426/134714907-254d9f3c-432b-4232-8b4e-019ef9d7f5bd.jpg" width="300">

- Dark Theme 적용된 홈 화면  
  <img src="https://user-images.githubusercontent.com/47319426/134713392-9d600237-5382-41f0-bdd9-6798e4221482.jpg" width="300">

## 3. 적용기술
`Kotlin` `MVVM` `ViewModel` `LiveData` `Coroutine` `DataBinding` `Dagger2` `Retrofit2` `OkHttpClient` `Android-KTX` `Paging3` `Glide` `SwiperRefreshLayout` `BottomNavigationView`
<br><br><br>
***
***

# Docfriends_Android_Recruit

안녕하세요

닥프렌즈 Android 개발자 채용에 지원해주셔서 감사합니다.

깃헙 [repository](https://github.com/Docfriends/Docfriends_Android_Recruit)를 fork하신 뒤, 작업하여 폴더에 solution을 넣어 push 해주시면 됩니다.

이 프로젝트의 목적은 Android를 활용해서 UI를 만드는 것 입니다.

전달되는 데이터의 형태를 확인하여 하단의 기능을 작동하는 UI를 만들어주시면 됩니다.

UI구조에 정확한 정답은 없으며, 해당 구조로 만든 이유를 설명할 수 있으면 됩니다.

# Guidelines

* 마감 기한은 과제 공유 메일이 도착한 일주일 후 입니다.
* Project는 빌드가 필수 전제이나, Project가 완벽하지 않아도 됩니다.
* Git을 반드시 사용해주세요.
* 개발 언어는 Kotlin를 사용해주세요.
* 특정 기능에 대한 라이브러리를 쓰셔도 무방합니다.
* 작업을 commit 단위로 나눠주세요
* 질문이 있으실 경우 info@docfriends.com으로 문의 부탁드립니다.

# Example

## 1. 홈

* 홈 탭만 구현하시면 됩니다.
* [홈 데이터(https://docfriends.github.io/Docfriends_Android_Recruit/api/home.json)](https://docfriends.github.io/Docfriends_Android_Recruit/api/home.json) 를 이용하여 화면을 표시 해주세요.
* Toolbar와 BottomBar는 개인이 편한 방식으로 개발 해주세요.
* 아이콘은 resources 폴더의 이미지를 사용해도 됩니다.
* Light Theme는 필수이지만 Drak Theme는 선택적으로 사용하셔도 됩니다.
* json데이터의 expertListPosition과 companyListPosition은 List의 index순서입니다.

<img src="example/home1.jpg" width="300">

* 상담 리스트가 나오는 화면입니다.

<br/>

<img src="example/home1.jpg" width="300">

* 상담 리스트 사이에 전문가 리스트가 나오는 화면입니다.

<br/>

<img src="example/home2.jpg" width="300">

* 상담 리스트 사이에 병원 리스트가 나오는 화면입니다.

<video controls autoplay width="300">
    <source src="example/sample.mp4" type="video/mp4"/>
</video>

* 전체 화면 샘플 영상입니다.

  <br/>

  <img src="example/home_full.jpg" width="300">

  * 전체 리스트 스크린샷 입니다.

