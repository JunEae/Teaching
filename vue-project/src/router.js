import{createRouter,createWebHistory} from 'vue-router';
import Home from "./components/Home.vue";
import Reg from "./components/Reg.vue";
import Log from "./components/Log.vue";
import Auth from "./components/Auth.vue";
import Account from "./components/Account.vue";
import Catalog from "./components/Catalog.vue"

export default  createRouter({
    history:createWebHistory(),
    routes:[
        {path:"/home",component:Home, alias:'/'},
        {path:"/reg",component:Reg},
        {path:"/log",component:Log},
        {path:"/auth",component:Auth},
        {path:"/acc",component:Account},
        {path:"/catalog", component:Catalog}
    ]
})