webpackJsonp([1],{"2Zo6":function(e,t){},"7F0t":function(e,t){},"89xK":function(e,t){},"8yFI":function(e,t){},K6VE:function(e,t){},NHnr:function(e,t,a){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var s=a("MVMM"),n={render:function(){var e=this.$createElement,t=this._self._c||e;return t("div",{attrs:{id:"app"}},[t("transition",{attrs:{name:"fade",mode:"out-in"}},[t("router-view")],1)],1)},staticRenderFns:[]};var o=a("Z0/y")({name:"app",components:{}},n,!1,function(e){a("89xK")},null,null).exports,i=a("zO6J"),r=a("aozt"),l=a.n(r),d={name:"",data:function(){return{formName:{user:"",userError:"",password:"",passwordError:"",beDisabled:!0},beShow:!1}},methods:{resetForm:function(){this.formName.user="",this.formName.userError="",this.formName.password="",this.formName.passwordError=""},submitForm:function(e){var t=this.formName.user,a=this.formName.password;console.log(t,a);var s={name:t,address:a};l.a.post("/shop/addNewShop",s).then(function(e){console.log(e)}).catch(function(){})},inputBlur:function(e,t){"user"===e?this.formName.userError=""===t?"用户名不能为空":"":"password"===e&&(this.formName.passwordError=""===t?"密码不能为空":""),""!=this.formName.user&&""!=this.formName.password?this.formName.beDisabled=!1:this.formName.beDisabled=!0}}},c={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("div",{staticClass:"dialog"},[a("div",{staticClass:"loginPage"},[a("h1",[e._v("登录")]),e._v(" "),a("el-form",[a("el-form-item",{attrs:{label:"user"}},[a("el-input",{attrs:{type:"text",id:"user"},on:{blur:function(t){e.inputBlur("user",e.formName.user)}},model:{value:e.formName.user,callback:function(t){e.$set(e.formName,"user",t)},expression:"formName.user"}}),e._v(" "),a("p",[e._v(e._s(e.formName.userError))])],1),e._v(" "),a("el-form-item",{attrs:{label:"password"}},[a("el-input",{attrs:{type:"password",id:"password"},on:{blur:function(t){e.inputBlur("password",e.formName.password)}},model:{value:e.formName.password,callback:function(t){e.$set(e.formName,"password",t)},expression:"formName.password"}}),e._v(" "),a("p",[e._v(e._s(e.formName.passwordError))])],1),e._v(" "),a("el-button",{attrs:{type:"primary",disabled:e.formName.beDisabled},on:{click:function(t){e.submitForm("formName")}}},[e._v("提交")]),e._v(" "),a("el-button",{on:{click:e.resetForm}},[e._v("重置")])],1)],1)])},staticRenderFns:[]};var m=a("Z0/y")(d,c,!1,function(e){a("7F0t")},"data-v-a6f39406",null).exports,u={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("我是view2")]),this._v(" "),t("a",[this._v("我是view2 ")])])}]};a("Z0/y")({name:"view2"},u,!1,function(e){a("RwkH")},null,null).exports;var p={data:function(){return{sysName:"ADMIN",collapsed:!1,sysUserName:"",sysUserAvatar:"",form:{name:"",region:"",date1:"",date2:"",delivery:!1,type:[],resource:"",desc:""}}},methods:{onSubmit:function(){console.log("submit!")},handleopen:function(){},handleclose:function(){},handleselect:function(e,t){console.log(e),console.log(t)},logout:function(){var e=this;this.$confirm("确认退出吗?","提示",{}).then(function(){sessionStorage.removeItem("user"),e.$router.push("/login")}).catch(function(){})},collapse:function(){this.collapsed=!this.collapsed},showMenu:function(e,t){this.$refs.menuCollapsed.getElementsByClassName("submenu-hook-"+e)[0].style.display=t?"block":"none"}},mounted:function(){var e={id:1,username:"admin",avatar:"https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1524292120746&di=d39e1d92247a6dc6a6a3818bfe2fc9d7&imgtype=0&src=http%3A%2F%2Fwww.17sucai.com%2Fupload%2F591517%2F2016-08-03%2F496e15e4acfad6738c64401198142e1e_big.png",name:"哆啦a梦"};e&&(this.sysUserName=e.name||"",this.sysUserAvatar=e.avatar||""),this.$router.push("/displayVender")}},f={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("el-row",{staticClass:"container"},[a("el-col",{staticClass:"header",attrs:{span:24}},[a("el-col",{staticClass:"logo",class:e.collapsed?"logo-collapse-width":"logo-width",attrs:{span:10}},[e._v("\n\t\t\t"+e._s(e.collapsed?"":e.sysName)+"\n\t\t")]),e._v(" "),a("el-col",{attrs:{span:10}},[a("div",{staticClass:"tools",on:{click:function(t){return t.preventDefault(),e.collapse(t)}}},[a("i",{staticClass:"fa fa-align-justify"})])]),e._v(" "),a("el-col",{staticClass:"userinfo",attrs:{span:4}},[a("el-dropdown",{attrs:{trigger:"hover"}},[a("span",{staticClass:"el-dropdown-link userinfo-inner"},[a("img",{attrs:{src:this.sysUserAvatar}}),e._v(" "+e._s(e.sysUserName))]),e._v(" "),a("el-dropdown-menu",{attrs:{slot:"dropdown"},slot:"dropdown"},[a("el-dropdown-item",[e._v("我的消息")]),e._v(" "),a("el-dropdown-item",[e._v("设置")]),e._v(" "),a("el-dropdown-item",{attrs:{divided:""},nativeOn:{click:function(t){return e.logout(t)}}},[e._v("退出登录")])],1)],1)],1)],1),e._v(" "),a("el-col",{staticClass:"main",attrs:{span:24}},[a("aside",{class:e.collapsed?"menu-collapsed":"menu-expanded"},[a("el-menu",{directives:[{name:"show",rawName:"v-show",value:!e.collapsed,expression:"!collapsed"}],staticClass:"el-menu-vertical-demo",attrs:{"default-active":e.$route.path,"unique-opened":"",router:""},on:{open:e.handleopen,close:e.handleclose,select:e.handleselect}},[e._l(e.$router.options.routes,function(t,s){return t.hidden?e._e():[t.leaf?e._e():a("el-submenu",{attrs:{index:s+""}},[a("template",{slot:"title"},[a("i",{class:t.iconCls}),e._v(e._s(t.name))]),e._v(" "),e._l(t.children,function(t){return t.hidden?e._e():a("el-menu-item",{key:t.path,attrs:{index:t.path}},[e._v(e._s(t.name))])})],2),e._v(" "),t.leaf&&t.children.length>0?a("el-menu-item",{attrs:{index:t.children[0].path}},[a("i",{class:t.iconCls}),e._v(e._s(t.children[0].name))]):e._e()]})],2),e._v(" "),a("ul",{directives:[{name:"show",rawName:"v-show",value:e.collapsed,expression:"collapsed"}],ref:"menuCollapsed",staticClass:"el-menu el-menu-vertical-demo collapsed"},e._l(e.$router.options.routes,function(t,s){return t.hidden?e._e():a("li",{staticClass:"el-submenu item"},[t.leaf?[a("li",{staticClass:"el-submenu"},[a("div",{staticClass:"el-submenu__title el-menu-item",class:e.$route.path==t.children[0].path?"is-active":"",staticStyle:{"padding-left":"20px",height:"56px","line-height":"56px",padding:"0 20px"},on:{click:function(a){e.$router.push(t.children[0].path)}}},[a("i",{class:t.iconCls})])])]:[a("div",{staticClass:"el-submenu__title",staticStyle:{"padding-left":"20px"},on:{mouseover:function(t){e.showMenu(s,!0)},mouseout:function(t){e.showMenu(s,!1)}}},[a("i",{class:t.iconCls})]),e._v(" "),a("ul",{staticClass:"el-menu submenu",class:"submenu-hook-"+s,on:{mouseover:function(t){e.showMenu(s,!0)},mouseout:function(t){e.showMenu(s,!1)}}},e._l(t.children,function(t){return t.hidden?e._e():a("li",{key:t.path,staticClass:"el-menu-item",class:e.$route.path==t.path?"is-active":"",staticStyle:{"padding-left":"40px"},on:{click:function(a){e.$router.push(t.path)}}},[e._v(e._s(t.name))])}))]],2)}))],1),e._v(" "),a("section",{staticClass:"content-container"},[a("div",{staticClass:"grid-content bg-purple-light"},[a("el-col",{staticClass:"breadcrumb-container",attrs:{span:24}},[a("strong",{staticClass:"title"},[e._v(e._s(e.$route.name))]),e._v(" "),a("el-breadcrumb",{staticClass:"breadcrumb-inner",attrs:{separator:"/"}},e._l(e.$route.matched,function(t){return a("el-breadcrumb-item",{key:t.path},[e._v("\n\t\t\t\t\t\t\t"+e._s(t.name)+"\n\t\t\t\t\t\t")])}))],1),e._v(" "),a("el-col",{staticClass:"content-wrapper",attrs:{span:24}},[a("transition",{attrs:{name:"fade",mode:"out-in"}},[a("router-view")],1)],1)],1)])])],1)},staticRenderFns:[]};var h=a("Z0/y")(p,f,!1,function(e){a("Ncns")},"data-v-52306252",null).exports,v={render:function(){this.$createElement;this._self._c;return this._m(0)},staticRenderFns:[function(){var e=this.$createElement,t=this._self._c||e;return t("div",[t("h1",[this._v("add product")]),this._v(" "),t("a",[this._v("add product ")])])}]};a("Z0/y")({name:"view2"},v,!1,function(e){a("2Zo6")},null,null).exports;var _=a("aA9S"),g=a.n(_),b={data:function(){return{filters:{name:""},venders:[],total:0,page:1,listLoading:!1,sels:[],editFormVisible:!1,editLoading:!1,editFormRules:{name:[{required:!0,message:"请输入厂家名称",trigger:"blur"}]},editForm:{id:0,name:"",telephone:"",address:""},addFormVisible:!1,addLoading:!1,addFormRules:{name:[{required:!0,message:"请输入厂家名称",trigger:"blur"}]},addForm:{name:"",telephone:"",address:""}}},methods:{getVenders:function(){var e={name:this.filters.name};this.listLoading=!0;var t=this;l.a.get("/vender/queryVendersByName",{params:e}).then(function(e){console.log(e),t.venders=e.data.venders,t.listLoading=!1}).catch(function(){t.listLoading=!1})},handleAdd:function(){this.addFormVisible=!0,this.addForm={name:"",telephone:"",address:""}},addSubmit:function(){var e=this;this.$refs.addForm.validate(function(t){t&&e.$confirm("确认提交吗？","提示",{}).then(function(){e.addLoading=!0;var t=g()({},e.addForm),a=e;l.a.post("/vender/addNewVender",t).then(function(e){console.log(e),a.addLoading=!1,a.$message({message:"提交成功",type:"success"}),a.$refs.addForm.resetFields(),a.addFormVisible=!1,a.getVenders()}).catch(function(){a.$message({message:"提交失败",type:"error"}),a.$refs.addForm.resetFields(),a.addFormVisible=!1,a.getVenders()})})})},handleEdit:function(e,t){this.editFormVisible=!0,this.editForm=g()({},t)},editSubmit:function(){var e=this;this.$refs.editForm.validate(function(t){t&&e.$confirm("确认提交吗？","提示",{}).then(function(){e.editLoading=!0;var t=g()({},e.editForm),a=e;l.a.patch("/vender/modifyVender",t).then(function(e){console.log(e),a.editLoading=!1,a.$message({message:"提交成功",type:"success"}),a.$refs.editForm.resetFields(),a.editFormVisible=!1,a.getVenders()}).catch(function(e){console.log(e),a.editLoading=!1,a.$message({message:"提交失败",type:"error"}),a.$refs.editForm.resetFields(),a.editFormVisible=!1,a.getVenders()})})})},handleDel:function(e,t){var a=this;this.$confirm("确认删除该厂家吗?","提示",{type:"warning"}).then(function(){a.listLoading=!0;var e={id:t.id},s=a;l.a.delete("/vender/deleteVenderById",{params:e}).then(function(e){s.listLoading=!1,s.$message({message:"删除成功",type:"success"}),s.getVenders()}).catch(function(e){s.listLoading=!1,s.$message({message:"删除失败",type:"error"}),s.getVenders()})}).catch(function(){})},selsChange:function(e){this.sels=e},batchRemove:function(){var e=this,t=this.sels.map(function(e){return e.id}).toString();this.$confirm("确认删除选中记录吗？","提示",{type:"warning"}).then(function(){e.listLoading=!0;var a={ids:t},s=e;l.a.delete("/vender/deleteVendersByIds",{params:a}).then(function(e){s.listLoading=!1,s.$message({message:"删除成功",type:"success"}),s.getVenders()}).catch(function(e){s.listLoading=!1,s.$message({message:"删除失败",type:"error"}),s.getVenders()})}).catch(function(){})}},mounted:function(){this.getVenders()}},F={render:function(){var e=this,t=e.$createElement,a=e._self._c||t;return a("section",[a("el-col",{staticClass:"toolbar",staticStyle:{"padding-bottom":"0px"},attrs:{span:24}},[a("el-form",{attrs:{inline:!0,model:e.filters}},[a("el-form-item",[a("el-input",{attrs:{placeholder:"厂家名称"},model:{value:e.filters.name,callback:function(t){e.$set(e.filters,"name",t)},expression:"filters.name"}})],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.getVenders}},[e._v("查询")])],1),e._v(" "),a("el-form-item",[a("el-button",{attrs:{type:"primary"},on:{click:e.handleAdd}},[e._v("新增")])],1)],1)],1),e._v(" "),a("el-table",{directives:[{name:"loading",rawName:"v-loading",value:e.listLoading,expression:"listLoading"}],staticStyle:{width:"100%"},attrs:{data:e.venders,"highlight-current-row":""},on:{"selection-change":e.selsChange}},[a("el-table-column",{attrs:{type:"selection",width:"55"}}),e._v(" "),a("el-table-column",{attrs:{type:"index",width:"60"}}),e._v(" "),e._e(),e._v(" "),a("el-table-column",{attrs:{prop:"name",label:"厂家名称",width:"180",sortable:""}}),e._v(" "),a("el-table-column",{attrs:{prop:"address",label:"地址","min-width":"180",sortable:""}}),e._v(" "),a("el-table-column",{attrs:{prop:"telephone",label:"电话",width:"180",sortable:""}}),e._v(" "),a("el-table-column",{attrs:{label:"操作",width:"150"},scopedSlots:e._u([{key:"default",fn:function(t){return[a("el-button",{attrs:{size:"small"},on:{click:function(a){e.handleEdit(t.$index,t.row)}}},[e._v("编辑")]),e._v(" "),a("el-button",{attrs:{type:"danger",size:"small"},on:{click:function(a){e.handleDel(t.$index,t.row)}}},[e._v("删除")])]}}])})],1),e._v(" "),a("el-col",{staticClass:"toolbar",attrs:{span:24}},[a("el-button",{attrs:{type:"danger",disabled:0===this.sels.length},on:{click:e.batchRemove}},[e._v("批量删除")])],1),e._v(" "),a("el-dialog",{attrs:{title:"编辑",visible:e.editFormVisible,"close-on-click-modal":!1},on:{"update:visible":function(t){e.editFormVisible=t}}},[a("el-form",{ref:"editForm",attrs:{model:e.editForm,"label-width":"80px",rules:e.editFormRules}},[e._e(),e._v(" "),a("el-form-item",{attrs:{label:"厂家名称",prop:"name"}},[a("el-input",{attrs:{"auto-complete":"off"},model:{value:e.editForm.name,callback:function(t){e.$set(e.editForm,"name",t)},expression:"editForm.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"电话"}},[a("el-input",{model:{value:e.editForm.telephone,callback:function(t){e.$set(e.editForm,"telephone",t)},expression:"editForm.telephone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"地址"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.editForm.address,callback:function(t){e.$set(e.editForm,"address",t)},expression:"editForm.address"}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{nativeOn:{click:function(t){e.editFormVisible=!1}}},[e._v("取消")]),e._v(" "),a("el-button",{attrs:{type:"primary",loading:e.editLoading},nativeOn:{click:function(t){return e.editSubmit(t)}}},[e._v("提交")])],1)],1),e._v(" "),a("el-dialog",{attrs:{title:"新增",visible:e.addFormVisible,"close-on-click-modal":!1},on:{"update:visible":function(t){e.addFormVisible=t}}},[a("el-form",{ref:"addForm",attrs:{model:e.addForm,"label-width":"80px",rules:e.addFormRules}},[a("el-form-item",{attrs:{label:"厂家名称",prop:"name"}},[a("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addForm.name,callback:function(t){e.$set(e.addForm,"name",t)},expression:"addForm.name"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"电话"}},[a("el-input",{attrs:{"auto-complete":"off"},model:{value:e.addForm.telephone,callback:function(t){e.$set(e.addForm,"telephone",t)},expression:"addForm.telephone"}})],1),e._v(" "),a("el-form-item",{attrs:{label:"地址"}},[a("el-input",{attrs:{type:"textarea"},model:{value:e.addForm.address,callback:function(t){e.$set(e.addForm,"address",t)},expression:"addForm.address"}})],1)],1),e._v(" "),a("div",{staticClass:"dialog-footer",attrs:{slot:"footer"},slot:"footer"},[a("el-button",{nativeOn:{click:function(t){e.addFormVisible=!1}}},[e._v("取消")]),e._v(" "),a("el-button",{attrs:{type:"primary",loading:e.addLoading},nativeOn:{click:function(t){return e.addSubmit(t)}}},[e._v("提交")])],1)],1)],1)},staticRenderFns:[]};var w=a("Z0/y")(b,F,!1,function(e){a("8yFI")},null,null).exports;s.default.use(i.a);var y=new i.a({linkActiveClass:"active",routes:[{path:"/",component:h,name:"厂家管理",iconCls:"fa fa-id-card-o",leaf:!0,children:[{path:"/displayVender",component:w,name:"厂家管理"}]},{path:"/",component:h,name:"商品管理",iconCls:"fa fa-cube",children:[{path:"/addShop",component:m,name:"页面4"},{path:"/addShop",component:m,name:"页面5"}]},{path:"/",component:h,name:"客户管理",iconCls:"fa fa-address-card",children:[{path:"/addShop",component:m,name:"客户"}]},{path:"/",component:h,name:"订单管理",iconCls:"fa fa-file-text-o",children:[{path:"/addShop",component:m,name:"客户"}]},{path:"/",component:h,name:"店铺管理",iconCls:"fa fa-bank",children:[{path:"/addShop",component:m,name:"客户"}]},{path:"/",component:h,name:"图表分析",iconCls:"fa fa-bar-chart",children:[{path:"/addShop",component:m,name:"echarts"}]}]}),$=a("5VXh"),C=a.n($),x=(a("K6VE"),a("9rMa"));a("uxEr");s.default.use(C.a),s.default.use(i.a),s.default.use(x.a),s.default.config.productionTip=!1,s.default.prototype.$ajax=l.a,new s.default({el:"#app",router:y,components:{App:o},template:"<App/>"})},Ncns:function(e,t){},RwkH:function(e,t){},uxEr:function(e,t){}},["NHnr"]);
//# sourceMappingURL=app.c5f9033ee08f1d297775.js.map