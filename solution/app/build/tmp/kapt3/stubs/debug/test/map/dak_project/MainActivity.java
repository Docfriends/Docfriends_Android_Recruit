package test.map.dak_project;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010+\u001a\u00020,H\u0002J\u0012\u0010-\u001a\u00020,2\b\u0010.\u001a\u0004\u0018\u00010/H\u0014J\b\u00100\u001a\u00020,H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058BX\u0082\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0096\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\'\"\u0004\b(\u0010)R\u0010\u0010*\u001a\u0004\u0018\u00010\u0005X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u00061"}, d2 = {"Ltest/map/dak_project/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lkotlinx/coroutines/CoroutineScope;", "()V", "binding", "Ltest/map/dak_project/databinding/ActivityMainBinding;", "getBinding", "()Ltest/map/dak_project/databinding/ActivityMainBinding;", "companyMainAdapter", "Ltest/map/dak_project/adapter/companyAdapter/CompanyMainAdapter;", "getCompanyMainAdapter", "()Ltest/map/dak_project/adapter/companyAdapter/CompanyMainAdapter;", "setCompanyMainAdapter", "(Ltest/map/dak_project/adapter/companyAdapter/CompanyMainAdapter;)V", "consultAdapter", "Ltest/map/dak_project/adapter/ConsultAdapter;", "getConsultAdapter", "()Ltest/map/dak_project/adapter/ConsultAdapter;", "setConsultAdapter", "(Ltest/map/dak_project/adapter/ConsultAdapter;)V", "coroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "dakViewModel", "Ltest/map/dak_project/adapter/viewModel/DakViewModel;", "getDakViewModel", "()Ltest/map/dak_project/adapter/viewModel/DakViewModel;", "setDakViewModel", "(Ltest/map/dak_project/adapter/viewModel/DakViewModel;)V", "expertTitleAdapter", "Ltest/map/dak_project/adapter/expertAdapter/ExpertTitleAdapter;", "getExpertTitleAdapter", "()Ltest/map/dak_project/adapter/expertAdapter/ExpertTitleAdapter;", "setExpertTitleAdapter", "(Ltest/map/dak_project/adapter/expertAdapter/ExpertTitleAdapter;)V", "job", "Lkotlinx/coroutines/Job;", "getJob", "()Lkotlinx/coroutines/Job;", "setJob", "(Lkotlinx/coroutines/Job;)V", "mainBinding", "dakRecyclerViewset", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recyclerviewSet", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements kotlinx.coroutines.CoroutineScope {
    private test.map.dak_project.databinding.ActivityMainBinding mainBinding;
    public test.map.dak_project.adapter.ConsultAdapter consultAdapter;
    public test.map.dak_project.adapter.expertAdapter.ExpertTitleAdapter expertTitleAdapter;
    public test.map.dak_project.adapter.companyAdapter.CompanyMainAdapter companyMainAdapter;
    public test.map.dak_project.adapter.viewModel.DakViewModel dakViewModel;
    public kotlinx.coroutines.Job job;
    private java.util.HashMap _$_findViewCache;
    
    public MainActivity() {
        super();
    }
    
    private final test.map.dak_project.databinding.ActivityMainBinding getBinding() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final test.map.dak_project.adapter.ConsultAdapter getConsultAdapter() {
        return null;
    }
    
    public final void setConsultAdapter(@org.jetbrains.annotations.NotNull()
    test.map.dak_project.adapter.ConsultAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final test.map.dak_project.adapter.expertAdapter.ExpertTitleAdapter getExpertTitleAdapter() {
        return null;
    }
    
    public final void setExpertTitleAdapter(@org.jetbrains.annotations.NotNull()
    test.map.dak_project.adapter.expertAdapter.ExpertTitleAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final test.map.dak_project.adapter.companyAdapter.CompanyMainAdapter getCompanyMainAdapter() {
        return null;
    }
    
    public final void setCompanyMainAdapter(@org.jetbrains.annotations.NotNull()
    test.map.dak_project.adapter.companyAdapter.CompanyMainAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final test.map.dak_project.adapter.viewModel.DakViewModel getDakViewModel() {
        return null;
    }
    
    public final void setDakViewModel(@org.jetbrains.annotations.NotNull()
    test.map.dak_project.adapter.viewModel.DakViewModel p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job getJob() {
        return null;
    }
    
    public final void setJob(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.Job p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlin.coroutines.CoroutineContext getCoroutineContext() {
        return null;
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void dakRecyclerViewset() {
    }
    
    private final void recyclerviewSet() {
    }
}