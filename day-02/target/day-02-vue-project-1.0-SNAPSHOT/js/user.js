var vue = new Vue({
    el:"#app",
    data:{
        user:{
            id : "",
            age :"",
            username :"",
            password: "",
            email:  "",
            sex: "",
        },
        userList:[]  //先定义一个空集合
    },
    methods:{
        findAll:function () {
          //  var _this = this;
            axios.get('/user/findAll.do')
                .then(function (response) {
                    vue.userList= response.data;  //
                   console.log(response);
                })
                .catch(function (error) {
                   console.log(error);
                })
            
        },
        findById:function (userId) {
            /*只用通过urlSearchParams()函数才能用post 方式往路径里面封装数据*/
            var param = new URLSearchParams();
            param.append("id" , userId);
            /*只用通过urlSearchParams()函数才能用post 方式往路径里面封装数据  @RequestParam 才能获取到数据*/
            axios.post('/user/findUserById.do', param)
                .then(function (response) {
                    vue.user=response.data;
                    $("#myModal").modal("show");
                    console.log();

                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        update:function (user) {

            axios.post('/user/updateUser.do',user)   // 如果 @update(user) 不传参数 , 可以使用 vue.user
                .then(function (response) {
                    alert(response.data);
                    vue.findAll();
                })
                .catch(function (error) {

                })
        }

    },
    created:function () {  // 加载页面的事后触发请求，查询所有
        this.findAll();
    }




});