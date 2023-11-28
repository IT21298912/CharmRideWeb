<template>
  <div class="example">
    <VueApexCharts
      height="350"
      type="bar"
      :options="chartOptions"
      :series="chartData.series"
    ></VueApexCharts>
  </div>
</template>

<script>
import VueApexCharts from "vue3-apexcharts";
import axios from "axios";

export default {
  components: {
    VueApexCharts,
  },
  data() {
    return {
      chartOptions: {
        // Your chart options (as provided in your code)
      },
      chartData: {
        series: [], // Initialize with an empty array
      },
    };
  },

  mounted() {
    axios
      .get("https://charm-ride.pockethost.io/api/collections/trip/records")
      .then((response) => {
        // Extract data from the response
        const data = response.data.items;

        // Create an object to store data per day
        const daysData = {};

        data.forEach((record) => {
          const date = record.created.split(" ")[0]; // Extract the date portion

          if (!daysData[date]) {
            daysData[date] = new Set();
          }

          daysData[date].add(record.userMail);
        });

        // Extract the unique user counts for each day
        const userCounts = Object.keys(daysData).map((date) => {
          return {
            x: date,
            y: daysData[date].size,
          };
        });

        // Define series data for the chart
        const seriesData = [
          {
            name: "Unique Users",
            data: userCounts,
          },
        ];

        // Update the chartData with the formatted data
        this.chartData.series = seriesData;
      })
      .catch((error) => {
        console.error("Failed to fetch data:", error);
      });
  },
};
</script>
