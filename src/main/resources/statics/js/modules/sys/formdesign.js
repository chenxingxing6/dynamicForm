$(function () {
    $("#jqGrid").jqGrid({
        url: baseURL + 'sys/formdesign/list',
        datatype: "json",
        colModel: [
			{ label: 'id', name: 'id', index: 'id', width: 50, key: true, hidden: true},
			{ label: '表单名', name: 'formName', index: 'form_name', width: 80 },
			{ label: '创建者', name: 'createUser', index: 'create_user', width: 80 },
			{ label: '修改时间', name: 'opTime', index: 'op_time', width: 80 },
            { label: '其他', name: 'viewFlag', index: 'view_flag', width: 80,
                formatter: function (value, grid, rows, state) {
                    var result = '';
                    var type = rows.type;
                    var viewFlag = rows.viewFlag;
                    result = result+ '<a href="javascript:void(0);" style="color:#f60" onclick="vm.view('+rows.id+')">查看 </a>';
                    return result;
                }}
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
		formDesign: {},
        html: '<h1>这是一段内容,这是一段内容,这是一段内容,这是一段内容。</h1>'
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
        view: function(id){
            vm.getInfo(id);
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
