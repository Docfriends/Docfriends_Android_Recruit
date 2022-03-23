package test.map.dak_project.retrofit;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u000e\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0007H\'\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\b"}, d2 = {"Ltest/map/dak_project/retrofit/Retrofit_InterFace;", "", "DakResultSet", "Lretrofit2/Response;", "Ltest/map/dak_project/dakmodel_Package/DakItem;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "DakSet", "Lretrofit2/Call;", "app_debug"})
public abstract interface Retrofit_InterFace {
    
    @org.jetbrains.annotations.NotNull()
    @retrofit2.http.GET(value = "Docfriends_Android_Recruit/api/home.json")
    public abstract retrofit2.Call<test.map.dak_project.dakmodel_Package.DakItem> DakSet();
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "Docfriends_Android_Recruit/api/home.json")
    public abstract java.lang.Object DakResultSet(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<test.map.dak_project.dakmodel_Package.DakItem>> continuation);
}