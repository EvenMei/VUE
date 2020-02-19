var vue = new Vue({
    el:"#app",
    data:{
        user:{
            id:"",
            age:"",
            username:"",
            password:"",
            email:"",
            sex:""
        },
        userList:[]  // useList的集合 创建vue的时候获取

    },
    methods:{
        findAll:function () {
            var _this = this;
            axios.post('/user/findAll.do')
                .then(function (response) {
                    _this.userList=response.data;


                })
                .catch(function (error) {
                    console.log(error);
                })

        },
        findById:function (userId) {
            var params = new URLSearchParams();
            params.append("id" , userId);
            var _this = this;
            axios.post('/user/findUserById.do',params)
                .then(function (response) {
                    _this.user=response.data;
                    $("#myModal").modal("show");
                })
                .catch(function (error) {
                    console.log(error);
                })
        },
        update:function (user) {
            var  _this  = this;
            axios.post('/user/updateUser.do' , _this.user)
                .then(function (response) {
                    _this.findAll();  //刷新页面
                    alert(response.data);
                   // $("#myModal").modal("hide"); // 这个功能是配合 @keydown.enter="update(user)"
                })
                .catch(function (error) {
                    console.log(error);
                })
        }



    },
    created:function () {
        this.findAll();  // 这儿 只能用 this.findAll();   不能使用 vue.findAll();  //因为还没创建完成

    }


});