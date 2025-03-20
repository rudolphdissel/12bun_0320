
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderServiceOrderManager from "./components/listers/OrderServiceOrderCards"
import OrderServiceOrderDetail from "./components/listers/OrderServiceOrderDetail"

import GoodsinformationView from "./components/GoodsinformationView"
import GoodsinformationViewDetail from "./components/GoodsinformationViewDetail"
import SupportServiceDeliveryManager from "./components/listers/SupportServiceDeliveryCards"
import SupportServiceDeliveryDetail from "./components/listers/SupportServiceDeliveryDetail"
import SupportServiceInventoryManager from "./components/listers/SupportServiceInventoryCards"
import SupportServiceInventoryDetail from "./components/listers/SupportServiceInventoryDetail"


import MyviewView from "./components/MyviewView"
import MyviewViewDetail from "./components/MyviewViewDetail"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orderServices/orders',
                name: 'OrderServiceOrderManager',
                component: OrderServiceOrderManager
            },
            {
                path: '/orderServices/orders/:id',
                name: 'OrderServiceOrderDetail',
                component: OrderServiceOrderDetail
            },

            {
                path: '/orderServices/goodsinformations',
                name: 'GoodsinformationView',
                component: GoodsinformationView
            },
            {
                path: '/orderServices/goodsinformations/:id',
                name: 'GoodsinformationViewDetail',
                component: GoodsinformationViewDetail
            },
            {
                path: '/supportServices/deliveries',
                name: 'SupportServiceDeliveryManager',
                component: SupportServiceDeliveryManager
            },
            {
                path: '/supportServices/deliveries/:id',
                name: 'SupportServiceDeliveryDetail',
                component: SupportServiceDeliveryDetail
            },
            {
                path: '/supportServices/inventories',
                name: 'SupportServiceInventoryManager',
                component: SupportServiceInventoryManager
            },
            {
                path: '/supportServices/inventories/:id',
                name: 'SupportServiceInventoryDetail',
                component: SupportServiceInventoryDetail
            },


            {
                path: '/dashboardServices/myviews',
                name: 'MyviewView',
                component: MyviewView
            },
            {
                path: '/dashboardServices/myviews/:id',
                name: 'MyviewViewDetail',
                component: MyviewViewDetail
            },


    ]
})
