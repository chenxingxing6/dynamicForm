$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/formdesign/list',
        datatype: "json",
        colModel: [			
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true },
			{ label: '表单名', name: 'formName', index: 'form_name', width: 80 }, 			
			{ label: '页面编辑好的原始html', name: 'template', index: 'template', width: 80 }, 			
			{ label: '反解析出来的页面html代码', name: 'html', index: 'html', width: 80 }, 			
			{ label: '自定义的各个控件字段的jsonarray格式存储', name: 'dataStr', index: 'data_str', width: 80 }, 			
			{ label: '', name: 'parse', index: 'parse', width: 80 }, 			
			{ label: '', name: 'fields', index: 'fields', width: 80 }, 			
			{ label: '是否有效', name: 'isValid', index: 'is_valid', width: 80 }, 			
			{ label: '登录者', name: 'createUser', index: 'create_user', width: 80 }, 			
			{ label: '登录时间', name: 'createTime', index: 'create_time', width: 80 }, 			
			{ label: '更新者', name: 'opUser', index: 'op_user', width: 80 }, 			
			{ label: '更新时间', name: 'opTime', index: 'op_time', width: 80 }, 			
			{ label: '版本号', name: 'lastVer', index: 'last_ver', width: 80 }			
        ],
		viewrecords: true,
        height: 385,
        rowNum: 10,
		rowList : [10,30,50],
        rownumbers: true, 
        rownumWidth: 25, 
        autowidth:true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader : {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames : {
            page:"page", 
            rows:"limit", 
            order: "order"
        },
        gridComplete:function(){
        	//隐藏grid底部滚动条
        	$("#jqGrid").closest(".ui-jqgrid-bdiv").css({ "overflow-x" : "hidden" }); 
        }
    });
});

var vm = new Vue({
	el:'#rrapp',
	data:{
		showList: true,
		title: null,
		formDesign: {}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function(){
			vm.showList = false;
			vm.title = "新增";
			vm.formDesign = {};
		},
		update: function (event) {
			var id = getSelectedRow();
			if(id == null){
				return ;
			}
			vm.showList = false;
            vm.title = "修改";
            
            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
			var url = vm.formDesign.id == null ? "sys/formdesign/save" : "sys/formdesign/update";
			$.ajax({
				type: "POST",
			    url: baseURL + url,
                contentType: "application/json",
			    data: JSON.stringify(vm.formDesign),
			    success: function(r){
			    	if(r.code === 0){
						alert('操作成功', function(index){
							vm.reload();
						});
					}else{
						alert(r.msg);
					}
				}
			});
		},
		del: function (event) {
			var ids = getSelectedRows();
			if(ids == null){
				return ;
			}
			
			confirm('确定要删除选中的记录？', function(){
				$.ajax({
					type: "POST",
				    url: baseURL + "sys/formdesign/delete",
                    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function(r){
						if(r.code == 0){
							alert('操作成功', function(index){
								$("#jqGrid").trigger("reloadGrid");
							});
						}else{
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get(baseURL + "sys/formdesign/info/"+id, function(r){
                vm.formDesign = r.formDesign;
            });
		},
		reload: function (event) {
			vm.showList = true;
			var page = $("#jqGrid").jqGrid('getGridParam','page');
			$("#jqGrid").jqGrid('setGridParam',{ 
                page:page
            }).trigger("reloadGrid");
		}
	}
});