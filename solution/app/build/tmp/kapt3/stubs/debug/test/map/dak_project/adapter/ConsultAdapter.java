package test.map.dak_project.adapter;

import java.lang.System;

@kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0003J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001c\u0010\u0013\u001a\u00020\u00142\n\u0010\u0015\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u001c\u0010\u0017\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016J\u0018\u0010\u001b\u001a\u00020\u00142\u000e\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H\u0007R \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u001e"}, d2 = {"Ltest/map/dak_project/adapter/ConsultAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Ltest/map/dak_project/adapter/ConsultAdapter$ConsultViewHolder;", "()V", "consultmodel", "", "Ltest/map/dak_project/dakmodel_Package/Consult;", "getConsultmodel", "()Ljava/util/List;", "setConsultmodel", "(Ljava/util/List;)V", "tagListAdapter", "Ltest/map/dak_project/adapter/TagListAdapter;", "getTagListAdapter", "()Ltest/map/dak_project/adapter/TagListAdapter;", "setTagListAdapter", "(Ltest/map/dak_project/adapter/TagListAdapter;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "submitList", "list", "ConsultViewHolder", "app_debug"})
public final class ConsultAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<test.map.dak_project.adapter.ConsultAdapter.ConsultViewHolder> {
    public java.util.List<test.map.dak_project.dakmodel_Package.Consult> consultmodel;
    public test.map.dak_project.adapter.TagListAdapter tagListAdapter;
    
    public ConsultAdapter() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<test.map.dak_project.dakmodel_Package.Consult> getConsultmodel() {
        return null;
    }
    
    public final void setConsultmodel(@org.jetbrains.annotations.NotNull()
    java.util.List<test.map.dak_project.dakmodel_Package.Consult> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final test.map.dak_project.adapter.TagListAdapter getTagListAdapter() {
        return null;
    }
    
    public final void setTagListAdapter(@org.jetbrains.annotations.NotNull()
    test.map.dak_project.adapter.TagListAdapter p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public test.map.dak_project.adapter.ConsultAdapter.ConsultViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    test.map.dak_project.adapter.ConsultAdapter.ConsultViewHolder holder, int position) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    public final void submitList(@org.jetbrains.annotations.Nullable()
    java.util.List<test.map.dak_project.dakmodel_Package.Consult> list) {
    }
    
    @kotlin.Metadata(mv = {1, 6, 0}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\r"}, d2 = {"Ltest/map/dak_project/adapter/ConsultAdapter$ConsultViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Ltest/map/dak_project/databinding/ConsultlistItemBinding;", "(Ltest/map/dak_project/adapter/ConsultAdapter;Ltest/map/dak_project/databinding/ConsultlistItemBinding;)V", "getBinding", "()Ltest/map/dak_project/databinding/ConsultlistItemBinding;", "setBinding", "(Ltest/map/dak_project/databinding/ConsultlistItemBinding;)V", "bind", "", "item", "Ltest/map/dak_project/dakmodel_Package/Consult;", "app_debug"})
    public final class ConsultViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private test.map.dak_project.databinding.ConsultlistItemBinding binding;
        
        public ConsultViewHolder(@org.jetbrains.annotations.NotNull()
        test.map.dak_project.databinding.ConsultlistItemBinding binding) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final test.map.dak_project.databinding.ConsultlistItemBinding getBinding() {
            return null;
        }
        
        public final void setBinding(@org.jetbrains.annotations.NotNull()
        test.map.dak_project.databinding.ConsultlistItemBinding p0) {
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        test.map.dak_project.dakmodel_Package.Consult item) {
        }
    }
}