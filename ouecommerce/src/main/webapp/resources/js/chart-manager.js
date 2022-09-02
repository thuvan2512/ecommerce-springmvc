
function loadChartTopSeller(labels, data) {
    const ctx = document.getElementById('chart-top-seller').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Top Seller',
                    data: data,
                    backgroundColor: [
                        '#74b9ff',
                        '#d63031',
                        '#1abc9c',
                        '#fdcb6e',
                        '#0984e3',
                        '#2d3436',
                        '#00b894',
                        '#e17055',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
function loadChartStatsCategory(labels, data) {
    const ctx = document.getElementById('chart-stats-by-category').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: labels,
            datasets: [{
                    label: 'Statistics by product category',
                    data: data,
                    backgroundColor: [
                        '#d63031',
                        '#1a7c9c',
                        '#fdcb6e',
                        '#e17055',
                        '#2d3436',
                        '#0984e3',
                        '#00b894',
                        '#7459ff',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 1
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
function loadChartRevenueStatsMonth(data, year) {
    const ctx = document.getElementById('chart-stats-revenue-month').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'line',
        data: {
            labels: [
                'January',
                'February',
                'March',
                'April',
                'May',
                'June',
                'July',
                'August',
                'September',
                'October',
                'November',
                'December'
            ],
            datasets: [{
                    fill: true,
                    borderColor: '#d63031',
                    tension: 0,
                    label: `Revenue Statistics By Month (${year})`,
                    data: data,
                    backgroundColor: [
                        'rgba(255, 99, 132, 0.5)',
                    ],
                    borderWidth: 3
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
function loadChartRevenueStatsQuarter(data, year) {
    const ctx = document.getElementById('chart-stats-revenue-quarter').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'pie',
        data: {
            labels: [
                'Quarter 1st',
                'Quarter 2nd',
                'Quarter 3rd',
                'Quarter 4th',
            ],
            datasets: [{
                    fill: false,
                    borderColor: '#d63031',
                    tension: 0,
                    label: `Revenue Statistics By Quarter (${year})`,
                    data: data,
                    backgroundColor: [
                        '#d63031',
                        '#1a7c9c',
                        '#fdcb6e',
                        '#e17055',
                        '#2d3436',
                        '#0984e3',
                        '#00b894',
                        '#7459ff',
                        '#d63031',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 0
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
function loadChartRevenueStatsYear(labels, data) {
    const ctx = document.getElementById('chart-stats-revenue-year').getContext('2d');
    const myChart = new Chart(ctx, {
        type: 'bar',
        data: {
            labels: labels,
            datasets: [{
                    fill: false,
                    borderColor: '#d63031',
                    tension: 0,
                    label: `Revenue Statistics By Year`,
                    data: data,
                    backgroundColor: [
                        '#e17055',
                        '#2d3436',
                        '#0984e3',
                        '#00b894',
                        '#7459ff',
                        '#d63031',
                        '#d63031',
                        '#1a7c9c',
                        '#fdcb6e',
                        '#8e44ad',
                        '#2ecc71',
                        '#bdc3c7',
                    ],
                    borderWidth: 0
                }]
        },
        options: {
            scales: {
                y: {
                    beginAtZero: true
                }
            }
        }
    });

}
