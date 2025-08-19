document.addEventListener('DOMContentLoaded', () => {
    const numStars = 100; // 생성할 별의 개수
    const body = document.body;

    // 별 애니메이션을 위한 CSS 스타일 추가
    const style = document.createElement('style');
    style.innerHTML = `
        .star {
            position: absolute;
            background-color: white;
            border-radius: 50%;
            opacity: 0;
            animation: twinkle-js linear infinite;
            z-index: -2; /* 별은 가장 뒤에 */
        }

        @keyframes twinkle-js {
            0%, 100% { opacity: 0.8; transform: scale(1); }
            50% { opacity: 0.2; transform: scale(0.8); }
        }
    `;
    document.head.appendChild(style);

    for (let i = 0; i < numStars; i++) {
        const star = document.createElement('div');
        star.classList.add('star');

        // 무작위 크기 (1px ~ 3px)
        const size = Math.random() * 2 + 1;
        star.style.width = `${size}px`;
        star.style.height = `${size}px`;

        // 무작위 위치
        star.style.left = `${Math.random() * 100}%`;
        star.style.top = `${Math.random() * 100}%`;

        // 무작위 애니메이션 지연 및 지속 시간
        star.style.animationDelay = `${Math.random() * 5}s`;
        star.style.animationDuration = `${Math.random() * 3 + 2}s`; // 2s ~ 5s

        body.appendChild(star);
    }

    // 태양의 초기 위치를 랜덤하게 설정
    const floatingSun = document.getElementById('floating-sun');
    if (floatingSun) {
        floatingSun.style.left = `${Math.random() * 80}%`; // 0% ~ 80% 범위
        floatingSun.style.top = `${Math.random() * 80}%`;   // 0% ~ 80% 범위

        // 행성 및 궤도 동적 생성
        const orbit = document.createElement('div');
        orbit.classList.add('orbit');
        floatingSun.appendChild(orbit);

        const planet = document.createElement('div');
        planet.classList.add('planet');
        floatingSun.appendChild(planet);
    }
});