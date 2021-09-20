<template>


    <div>
        <el-row class="editor_bar" style="padding-bottom: 10px">
            <el-select v-model="value" size="medium" placeholder="请选择" class="tool-bar-item">
                <el-option
                        v-for="item in options"
                        :key="item.value"
                        :label="item.label"
                        :value="item.value">

                </el-option>
            </el-select>
            <el-button type="primary" icon="el-icon-circle-plus-outline" size="small" round class="tool-bar-item">新增</el-button>
            <el-button type="success" icon="el-icon-edit" size="small" round class="tool-bar-item">编辑</el-button>
            <el-button type="danger" icon="el-icon-delete" size="small" round class="tool-bar-item">删除</el-button>
        </el-row>
        <el-table :data="tableData" stripe height="300" highlight-current-row style="height:100%; width: 100%">
            <el-table-column prop="name" label="属性名"></el-table-column>
            <el-table-column prop="value" label="属性值"></el-table-column>
            <el-table-column prop="remark" label="备注"></el-table-column>
            <el-table-column
                    fixed="right"
                    label="操作"
                    width="120">
                <template slot-scope="scope">
                    <el-button @click.native.prevent="deleteRow(scope.$index, tableData)" type="text" size="small">移除</el-button>
                    <el-button @click.native.prevent="updateRow(scope.$index, tableData)" type="text" size="small">编辑</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
</template>

<script>
export default {
    name: "Interpreter",
    data() {
        return {
            tabName: '解释器配置',
            options: [{
                value: 'Flink',
                label: 'Flink'
            }],
            value: 'Flink',
            tableData: [{
                value: '2016-05-02',
                name: '王小虎',
                remark: '上海市普陀区金沙江路 1518 弄'
            }, {
                value: '2016-05-03',
                name: '王小虎',
                remark: '上海市普陀区金沙江路 1518 弄'
            }]
        }
    },
    methods: {
        deleteRow(index, rows) {
            rows.splice(index, 1);
        },
        updateRow(index, rows) {
            console.log(index,rows)
            alert("updateRow")
        }
    },
    mounted() {
        this.$store.dispatch('base/setValue',{tabName: this.tabName})
    }
}
</script>

<style>

</style>