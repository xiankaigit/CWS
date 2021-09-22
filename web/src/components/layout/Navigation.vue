<template>
    <el-row class="tac">
        <el-col :span="12" style="width: 200px;">
            <el-menu style=""
                     default-active="2"
                     class="el-menu-vertical-demo"
                     @open="handleOpen"
                     @close="handleClose"
                     background-color="#545c64"
                     text-color="#fff"
                     active-text-color="#ffd04b"
                     :unique-opened="true">
                <el-submenu index="1">
                    <template slot="title">
                        <i class="el-icon-setting"></i>
                        <span>集群管理</span>
                    </template>
                    <el-menu-item index="1-1">集群配置</el-menu-item>
                    <el-menu-item index="1-2">集群监控</el-menu-item>
                    <el-menu-item index="1-3" @click="goTo('interpreter')">执行器</el-menu-item>
                </el-submenu>
                <el-submenu index="2">
                    <template slot="title">
                        <i class="el-icon-menu"></i>
                        <span>任务管理</span>
                    </template>
                    <el-menu-item index="2-1" @click="goTo('sql')">SQL任务</el-menu-item>
                    <el-menu-item index="2-2">可视化任务</el-menu-item>
                    <el-menu-item index="2-3">任务调度</el-menu-item>
                    <el-menu-item index="2-4">任务监控</el-menu-item>
                </el-submenu>
                <el-submenu index="3">
                    <template slot="title">
                        <i class="el-icon-my-table"></i>
                        <span>元数据</span>
                    </template>
                    <el-menu-item index="3-1">schema管理</el-menu-item>
                    <el-menu-item index="3-2" @click="goTo('tableManagement')">表管理</el-menu-item>
                </el-submenu>
            </el-menu>
        </el-col>
    </el-row>
</template>

<script>

import '../../assets/icon/iconfont.css'

export default {
    name: "Navigation",
    components: {},
    data() {
        return {
            "test": "test"
        }
    },
    methods: {
        handleOpen(key, keyPath) {
            //console.log(key, keyPath);
        },
        handleClose(key, keyPath) {
            //console.log(key, keyPath);
        },
        goTo(target) {
            this.$router.push({
                name: target
            })
        }
    },
    mounted() {
        this.$router.push({
            name: 'emptyPage'
        })
    }
};

</script>

<style scoped>
.el-submenu .el-menu-item {
    padding-left: 45px !important;
}
</style>
