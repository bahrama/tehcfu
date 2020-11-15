    const init = function() {
        const colors = [
            {id: 'one-a', main: '#8E2800', accent: '#B64926', text: '#fff'},
            {id: 'one-b', main: '#468966', accent: '#FFB03B', text: '#FFF0A5'},
            {id: 'two-a', main: '#2C3E50', accent: '#2980B9', text: '#fff'},
            {id: 'two-b', main: '#E74C3C', accent: '#3498DB', text: '#ECF0F1'},
            {id: 'three-a', main: '#962D3E', accent: '#979C9C', text: '#F2EBC7'},
            {id: 'three-b', main: '#343642', accent: '#348899', text: '#F2EBC7'},
            {id: 'four-a', main: '#405952', accent: '#9C9B7A', text: '#FFD393'},
            {id: 'four-b', main: '#F54F29', accent: '#FF974F', text: '#FFD393'}
        ];
        let usedColors = [];
        const panels = document.querySelectorAll('.panel');

        //initialize panel colors and click handler
        panels.forEach(panel => {
            let color = getColor();

            let details = panel.querySelector('.show-on-hover');
            let showMore = panel.querySelector('.learn-more');
            let close = panel.querySelector('.learn-more-header');

            panel.style.backgroundColor = color.main;
            panel.style.color = color.text;
            showMore.style.backgroundColor = color.accent;
            close.style.backgroundColor = color.main;
            close.style.color = color.text;
            details.addEventListener('click', function() {
                showMore.classList.remove('learn-more--hidden');
            }, false);
            close.addEventListener('click', function() {
                showMore.classList.add('learn-more--hidden');
            })
            panel.addEventListener('mouseover', slide, false);
            panel.addEventListener('mouseleave', function() {
                showMore.classList.add('learn-more--hidden');
            }, false);
        });

        function getColor() {
            let color = colors[random(0, colors.length)];
            while(usedColors.indexOf(color.id) !== -1) {
                color = colors[random(0, colors.length)];
            }
            usedColors.push(color.id);
            return color;
        }

        function slide() {
            panels.forEach(panel => {
                let myDetails = panel.querySelector('.show-on-hover');
                if(this === panel) {
                    this.classList.remove('shrink');
                    this.classList.add('grow');
                    myDetails.classList.add('show-on-hover--show');
                } else {
                    panel.classList.remove('grow');
                    panel.classList.add('shrink');
                    myDetails.classList.remove('show-on-hover--show');
                }
            });
        }

        function random(min, max) {
            min = Math.ceil(min);
            max = Math.floor(max);
            return Math.floor(Math.random() * (max - min)) + min;
        }
    }

    document.addEventListener('DOMContentLoaded', init, false);