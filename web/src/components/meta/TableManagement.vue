<template>
  <div>
      <el-row class="editor_bar" style="padding-bottom: 10px">
          <el-button type="primary" class="tool-bar-item" size="small" round>主要按钮</el-button>
      </el-row>
      <el-table :data="tableData" stripe style="width: 100%">
          <el-table-column prop="date" label="日期" style="width: 30%"></el-table-column>
          <el-table-column prop="name" label="姓名" style="width: 30%"></el-table-column>
          <el-table-column prop="address" label="地址" style="width: 40%"></el-table-column>
      </el-table>
  </div>
</template>

<script>
export default {
    data() {
        return {
            tabName: '表管理',
            tableData: [{
                date: '2016-05-02',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1518 弄'
            }, {
                date: '2016-05-04',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1517 弄'
            }, {
                date: '2016-05-01',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1519 弄'
            }, {
                date: '2016-05-03',
                name: '王小虎',
                address: '上海市普陀区金沙江路 1516 弄'
            }]
        }
    },
    mounted() {
        this.$store.dispatch('base/setValue',{tabName: this.tabName})
    }
}
</script>

<style>

</style>